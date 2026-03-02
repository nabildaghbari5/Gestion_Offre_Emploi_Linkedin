# BelsSageCore
Hi,

Rule 1: Rest API response used to be dynamic and for that we are going to use: ResponseEntity<?>
Response accept in argument a generic type could be a String, List, ... but could be ? to accept any kind of response sometime the same method could return String or Integer of course its depends from the situation.

Rule2: In case that a rest API service used to return value to be understood from the frontend as a status or response, its better to do not return String LIke 'Object exists' or 'Duplication'.
Its better to numbers:
For example please find below the list of possible status:
-1: Error and Failed
1: Success
2: Failed
3: Duplication
The list could be bigger and we could modify but the elements listed before are the basics.