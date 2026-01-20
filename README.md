# ICM Calculator

A simple Java program that calculates poker tournament equity using the **Independent Chip Model (ICM)**.

The program takes player chip stacks and a payout structure as input, then computes each player’s expected share of the prize pool based on proportional chip ownership and probabilistic eliminations.

Input is provided via a text file, and results are printed to the console in stack order.

## Command-Line Arguments

The program expects **one command-line argument**: the input file path

### Usage
```bash
java ICMCalculatorMain <input_file>
