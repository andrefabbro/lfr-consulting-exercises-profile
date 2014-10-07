User Profile Portlet
================================

This portlet is the solution for the Liferay Consulting exercises "User Profile - Edit & Display" and "User Profile - Simple Search".

### Steps to setup the project:

1. Create a new portlet project named user-profile-portlet.
2. Clone that repo into the project.
3. Deploy to any Liferay 6.2 EE Portal using Liferay SDK or generated WAR.

### Solution for Exercise 1 - "Edit & Display"

1. Edit the hosts file adding the amf.com as a host, like the follow:
  ```
  127.0.0.1       localhost amf.com
  ```
2. Create a page named "Member" with 1 Column and the friendly URL "/member", check the option "Hide from Navigation Menu".
3. Go to http://amf.com:8080/member/ and pull the portlet "User Profile" (under Sample category) to the page.
4. Create some users.
5. The URL http://amf.com:8080/member/-/profile/view/**screen_name** will show the profile for the user with screen name = **screen_name**.
6. The URL http://amf.com:8080/member/-/profile/edit will open the edit profile page.
7. The URL http://amf.com:8080/member/-/profile/privacy will open the visibility settings page.

###### Notes about the solution

I've created two entities with the Service Builder, one named the GeneralProfile, and the other MovieInterest, 
each one with the correspondent attribute from the requirements.
Regarding the other attributes, related to Basic Info, I've used the Contact entity (com.liferay.portal.model.Contact) 
already existent in Liferay to store firstname, lastname, male and birthday.

The first challenge was to create the Action Permission for that Contact entity in order to control the visibility setting 
for that section. I did that creating a new model resource named com.amf.user.profile.model.BasicInfo, although isn't a 
persistence entity serves to bind the visibility setting to the Contact entity since that already exists in Liferay.

I've also used the default actions "doView", "doEdit" and "doConfig", each one for the view profile, edit profile and change 
visibility settings respectively, in order to be closer to spec.

### Solution for Exercise 2 - "Simple Search"

1. Create a page named "Search" with 1 Column and the friendly URL "/member/search".
2. Go to http://amf.com:8080/member/search and pull the portlet "Profile Search" (under Sample category) to the page.

###### Notes about the solution

I've created another portlet named Profile Search just for that use-case.

The biggest challenge of that exercise was to create only one Lucene index which have to refers to the three 
entities: GeneralProfile, MovieInterest and Contact. Although I had created one Indexer for GeneralProfile and 
MovieInterest (the Contact already has it's own Indexer), I had to create another entity, 
named UserProfile (com.amf.user.profile.UserProfile), which encapsulates the GeneralProfile, 
Contact and MovieInterest. Also I had to put that UserProfile in the BaseModel's hierarchy (com.liferay.portal.model.BaseModel<T>) 
in order to be able to create an Indexer with all attributes as needed.

Sadly, there are two requirements that I couldn't accomplish because didn't have enough time. 
The first was about don't search records that are marked as private in the profile visibility 
settings. I figured out that I'd have to override the *hasPermission* method in the Indexer which extends 
BaseIndexer, but I didn't find out how to do it exactly.

The second was about to use the Liferay's built in pagination tag on the search results. 
I realized that tag is used with searchContainer built in tag, but I didn't find a way 
to use the searchContainer with AJAX mode, so I made it happen by implementing 
my own pagination algorithm.

