# Gene Catcher

An algorithm to identify all genes in a strand of DNA using Java.

## Input

A list of text files, each file contains a strand of DNA.

## Output

Total genes for every DNA strand.

## Domain Knowledge:

-   The genome of organism storess all the genetic information necessary to build and maintain that organism, This genetic information is stored as a long list or string over the four letter alphabet A, T, C and G. These four characters correspond to the four DNA bases: Adenine, Thymine, Cytosine and Guanine.
-   The human genome contains 3 billion characters. Each of these represent one nucleotide.
-   Three nucleotides together make a codon which each describe one amino acid.
-   Real genes are multiples of 3.
-   ATG is a special codon that indicates the start of a gene (start codon).
-   TAA, TAG and TGA are special codons that indicate the end of a gene (stop codons).
-   If the gene has multiple stop codons that make a valid gene, pick the stop codon with the smallest index.
-   The DNA string is called strand.

## How the algorithm validates the genes:

-   ATGTGGTAA is a valid gene because it starts with ATG and ends with TAA and is divisible by 3
-   ATGTTGA is not a valid gene because it's not divisible by 3
-   TTGTGA is not a valid gene because it's doesn't start with ATG
-   ATGTGGG is not a valid gene because it doesn't end with one of the stop codons: TGA, TAA or TAG

## Example:

**Input**: ATGAAATGA-CCC-ATGCTAA-ATGCCCTAG

**Output**: Total Genes = 2

**The found valid genes are**: "ATGAAATGA" and "ATGCCCTAG"
