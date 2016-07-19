# DeBruijn
/r/dailyprogrammer 274 Intermediate - Generating DeBruijn Sequences

"In combinatorial mathematics, a De Bruijn sequence of order n on a size-k alphabet A is a cyclic sequence in which every possible length-n string on A occurs exactly once as a substring."

i.e. DeBruijn(2,3) has alphabet {1,0} and contains every 3 length substring possible when the ends are attached

DeBruijn(2,3) = 11101000

I used the Duval Algorithm to generate Lyndon words:

If w is one of the words in the sequence, then the next word after w can be found by the following steps:

    1.Repeat the symbols from w to form a new word x of length exactly n, where the ith symbol of x is the same as the symbol at position (i mod length(w)) of w.
    2.As long as the final symbol of x is the last symbol in the sorted ordering of the alphabet, remove it, producing a shorter word.
    3.Replace the final remaining symbol of x by its successor in the sorted ordering of the alphabet.

ref. 
https://en.wikipedia.org/wiki/Lyndon_word
https://en.wikipedia.org/wiki/De_Bruijn_sequence