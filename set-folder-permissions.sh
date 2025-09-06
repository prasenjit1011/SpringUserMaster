#!/bin/bash
# Create uploads/distributors folder if it doesn't exist
folder="uploads/distributors"
if [ ! -d "$folder" ]; then
  mkdir -p "$folder"
fi
# Set read/write permissions for all users
touch "$folder/.permtest"
chmod 777 "$folder" "$folder/.permtest"
