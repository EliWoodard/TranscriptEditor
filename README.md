# Java Text Scrapper and Caption Updater

This repository contains two Java programs: a Text Scrapper and a Caption Updater.

## Text Scrapper

The `Scrapper` Java class reads an input text file, performs some cleaning operations, and writes the modified content to an output text file. The cleaning operations include removing all bracketed text (in either round, square, or curly brackets) and newlines from the input text.

The input file is expected to be in the `input` directory and should be named `input.txt`. The output file will be written to the `output` directory and will be named `output.txt`. 

### Running the Scrapper Program

1. Clone this repository to your local machine.
2. Navigate to the root directory of this project.
3. Compile the Java file with the command `javac Scrapper.java`.
4. Run the Java program with the command `java Scrapper`.

Please ensure that the `input` directory exists and contains the `input.txt` file, and that the `output` directory also exists. The program does not currently handle directory or file creation.

## Caption Updater

The `UpdateCaptions` Java class reads a text file containing video captions, and updates the timestamps to a new format.

The input caption file is expected to be in the `captions/input` directory and should be named `captions.txt`. The updated captions will be written to the `captions/output` directory and will be named `updated_captions.txt`.

### Running the UpdateCaptions Program

1. Clone this repository to your local machine.
2. Navigate to the root directory of this project.
3. Compile the Java file with the command `javac UpdateCaptions.java`.
4. Run the Java program with the command `java UpdateCaptions`.

Ensure that the `captions/input` directory exists and contains the `captions.txt` file, and that the `captions/output` directory also exists. The program does not currently handle directory or file creation.

## Contributions

Contributions, issues, and feature requests are welcome. Feel free to check the issues page if you want to contribute.
