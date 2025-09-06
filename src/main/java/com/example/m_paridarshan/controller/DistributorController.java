package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.DistributorDTO;
import com.example.m_paridarshan.model.Distributor;
import com.example.m_paridarshan.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController {
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/distributors";

    @Autowired
    private DistributorService distributorService;

    @PostMapping
    public ResponseEntity<DistributorDTO> createDistributor(@RequestParam("name") String name,
                                                           @RequestParam("emailid") String emailid,
                                                           @RequestParam(value = "profile_photo", required = false) MultipartFile profilePhoto) throws IOException {
        Distributor distributor = new Distributor();
        distributor.setName(name);
        distributor.setEmailid(emailid);

        if (profilePhoto != null && !profilePhoto.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + StringUtils.cleanPath(profilePhoto.getOriginalFilename());
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            System.out.println("Uploading to: " + filePath.toAbsolutePath());
            Files.write(filePath, profilePhoto.getBytes());
            distributor.setProfilePhotoPath("/uploads/distributors/" + fileName);
        }

        Distributor saved = distributorService.saveDistributor(distributor);
        DistributorDTO dto = toDTO(saved);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<DistributorDTO> getAllDistributors() {
        return distributorService.getAllDistributors().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistributorDTO> getDistributor(@PathVariable Long id) {
        Optional<Distributor> distributor = distributorService.getDistributorById(id);
        return distributor.map(value -> ResponseEntity.ok(toDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistributorDTO> updateDistributor(@PathVariable Long id,
                                                           @RequestParam("name") String name,
                                                           @RequestParam("emailid") String emailid,
                                                           @RequestParam(value = "profile_photo", required = false) MultipartFile profilePhoto) throws IOException {
        Optional<Distributor> optionalDistributor = distributorService.getDistributorById(id);
        if (!optionalDistributor.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Distributor distributor = optionalDistributor.get();
        distributor.setName(name);
        distributor.setEmailid(emailid);

        if (profilePhoto != null && !profilePhoto.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + StringUtils.cleanPath(profilePhoto.getOriginalFilename());
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) uploadDir.mkdirs();
                Path filePath = Paths.get(UPLOAD_DIR, fileName);
                System.out.println("Uploading to: " + filePath.toAbsolutePath());
                Files.write(filePath, profilePhoto.getBytes());
                distributor.setProfilePhotoPath("/uploads/distributors/" + fileName);
        }

        Distributor updated = distributorService.saveDistributor(distributor);
        DistributorDTO dto = toDTO(updated);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistributor(@PathVariable Long id) {
        distributorService.deleteDistributor(id);
        return ResponseEntity.noContent().build();
    }

    private DistributorDTO toDTO(Distributor distributor) {
        DistributorDTO dto = new DistributorDTO();
        dto.setId(distributor.getId());
        dto.setName(distributor.getName());
        dto.setEmailid(distributor.getEmailid());
        dto.setProfilePhotoUrl(distributor.getProfilePhotoPath());
        return dto;
    }
}
