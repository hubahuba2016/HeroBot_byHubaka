#!/bin/bash

echo "Building project..."
./gradlew clean build

if [ $? -eq 0 ]; then
    echo "Running application..."
    ./gradlew run --console=plain
else
    echo "Build failed. Fix errors first."
fi
