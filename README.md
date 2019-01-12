# Growth API (GAPI)  [MC 1.12.2]

Growth API is an API written in Java 8 which is meant to ease the modification of
 growth-processes in Minecraft.
 
 GAPI, as it currently stands, is a backend extension and thus will not provide any changes to Minecraft's gameplay on
 its own.
 
 For a quick start, include the api as a runtime dependency and read the wiki!
 
 ## Todo until next release:
 
 - ~~rewrite the base GrowthProfile classes and give them an interface backend~~  see  [commit](https://github.com/TomConnery/GrowthAPI/commit/ced4d1b94cd4e65cb776717180c49e9bc72d8200)
 - move this todo list to projects (Kappa)
 - add static-level entry functions which allow for obtaining all relevant instances (helpers etc. included)
 - add default-value methods to the library to help with tailoring ProbabilityFunctions that only have one value and otherwise a default one
 - rewrite the probabilities to have their own type instead of using double
 
 ## Changelog:
 
 ### 0.0.6: probability-function update
 
 - added chance-based profiles with an extensive backend
 
 
 ### 0.0.5: base release   
  
