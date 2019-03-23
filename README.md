# Growth API (GAPI)  [MC 1.12.2]

Growth API is an API written in Java 8 which is meant to ease the modification of
 growth-processes in Minecraft.
 
 GAPI, as it currently stands, is a backend extension and thus will not provide any changes to Minecraft's gameplay on
 its own.
 
 For a quick start, include the api as a runtime dependency and read the wiki!
 
 ## Note on 1.13
 
Forge was released for 1.13.2 and plans are to release 0.0.6 first. After that a new branch for the 1.13 update will be created. The initial featureset of the 1.13 branch will be the one of the 0.0.6 update.
 
The 1.12.2 branch will, after that, receive updates only as long as they are easy to invorporate, which is something I can make a statement on only after I have resolved any possible upcoming migration problems that arrive from switching to 13.2.

Continued 1.12.2 support is therefore **not** guaranteed!
 
 ## Todo until next release:

[0.0.6 release project](https://github.com/TomConnery/GrowthAPI/projects/2)

 
 ## Changelog:
 
 ### 0.0.6: probability-function update
 
 - added chance-based profiles with an extensive backend
 - added interface backends for event-helpers, requirement-helpers and growthprofiles
 - added static-level endpoints for obtaining instances for the interfaces and narrowed down access to all implementation classes
 - updated javadoc across the board to contain @since marks
 
 
 ### 0.0.5: base release   
  
