Custom Error Pages
If you want to display a custom HTML error page for a given status code, you can add a file to an /error directory. Error pages can either be static HTML (that is, added under any of the static resource directories) or be built by using templates. The name of the file should be the exact status code or a series mask.


To map all 5xx errors by using a FreeMarker template, your directory structure would be as follows:

src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- templates/
             +- error/
             |   +- 5xx.ftlh
             +- <other templates>