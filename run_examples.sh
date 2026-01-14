#!/bin/bash
# Skrip sederhana untuk meng-compile semua contoh dalam folder lessons
set -e
ROOT="$(dirname "$0")"
find "$ROOT/lessons" -name "*.java" > /tmp/java_files_list.txt
javac -d "$ROOT/lessons" @/tmp/java_files_list.txt
echo "Compile selesai. Untuk menjalankan, gunakan: java -cp lessons <NamaKelas>"
