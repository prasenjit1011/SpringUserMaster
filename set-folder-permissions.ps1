# Create uploads/distributors folder if it doesn't exist
$folder = "uploads/distributors"
if (!(Test-Path $folder)) {
    New-Item -ItemType Directory -Force -Path $folder
}
# Set read/write permissions for Everyone
$acl = Get-Acl $folder
$permission = "Everyone","FullControl","Allow"
$accessRule = New-Object System.Security.AccessControl.FileSystemAccessRule $permission
$acl.SetAccessRule($accessRule)
Set-Acl $folder $acl
