# SprayAndPray
This is an Android application design to aid in researching heap overflow vulnerabilities, and techniques such as heap spraying that can be used to exploit them.

I understand that functionaly the code will probably make zero fucking sense, so just keep in mind it was only written to be intentionally vulnerable.


```
struct chunk {
        char *file_chunk[255];
     };


    struct chunk *chunk = malloc(sizeof(chunk));
```
