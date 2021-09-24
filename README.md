## About the Project

Gene Catcher is an algorithm to identify all genes in a strand of DNA using Java.

## Input

A list of text files, each file contains a strand of DNA.

## Output

Total genes for every DNA strand.

## Domain Knowledge

-   The genome of organism storess all the genetic information necessary to build and maintain that organism, This genetic information is stored as a long list or string over the four letter alphabet A, T, C and G. These four characters correspond to the four DNA bases: Adenine, Thymine, Cytosine and Guanine.
-   The human genome contains 3 billion characters. Each of these represent one nucleotide.
-   Three nucleotides together make a codon which each describe one amino acid.
-   Real genes are multiples of 3.
-   ATG is a special codon that indicates the start of a gene (start codon).
-   TAA, TAG and TGA are special codons that indicate the end of a gene (stop codons).
-   If the gene has multiple stop codons that make a valid gene, pick the stop codon with the smallest index.
-   The DNA string is called strand.

## How the Algorithm Validates the Genes

-   ATGTGGTAA is a valid gene because it starts with ATG and ends with TAA and is divisible by 3
-   ATGTTGA is not a valid gene because it's not divisible by 3
-   TTGTGA is not a valid gene because it's doesn't start with ATG
-   ATGTGGG is not a valid gene because it doesn't end with one of the stop codons: TGA, TAA or TAG

## Examples

```
Input: ATGAAATGA-CCC-ATGCTAA-ATGCCCTAG

Output: Total Genes = 2

The found valid genes are: "ATGAAATGA" and "ATGCCCTAG"
```

```
Input: ATGCCCTGATAGTAA

Output: Total Genes = 1

The found valid gene is: "ATGAAATGA"

Explanation: This DNA strand has the three stop codons and all of them can make up a valid gene,
in this case, we find the stop codon that precedes the other stop codons which is "TGA"
```

## Algorithm Steps

1. Set fromIndex to 0

2. As long as more genes after fromIndex:

    2.1 Find the next gene after fromIndex

    2.2 Store the gene

    2.3 Set fromIndex to past the end of gene

## How to Run the Project

### Using CLI

    git clone https://github.com/ali-abdelqawy/gene-catcher.git
    cd gene-catcher/src/main/java
    javac Main.java
    java Main ..//..//..//input

### Using IntelliJ IDEA

    1. git clone https://github.com/ali-abdelqawy/gene-catcher.git
    2. Open the project with the compiler
    3. Click "Run" in the main menu
    4. Click "Edit configuration"
    5. Type "input" in the program arguments field
    6. Click "OK"
    7. Run the project

> Note: you need to install Java in order to run this project.
