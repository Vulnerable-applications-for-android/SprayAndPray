# SprayAndPray
This is an Android application design to aid in researching heap overflow vulnerabilities, and techniques such as heap spraying that can be used to exploit them.

I understand that functionally the code will probably make zero fucking sense, so just keep in mind it was only written to be intentionally vulnerable.


## JNI

```
struct chunk {
        char *file_chunk[255];
     };


    struct chunk *chunk = malloc(sizeof(chunk));
```

First we create a chunk structure with single character array member, which can hold 255 bytes.  An allocation is made for the chunk structure on the heap.  There is no reasoning behind its naming convention, as it will be passed in the entire file, and not an actual chunk of the file.
