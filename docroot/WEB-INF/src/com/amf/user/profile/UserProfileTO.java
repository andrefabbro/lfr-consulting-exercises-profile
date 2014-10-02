
package com.amf.user.profile;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.liferay.portal.model.Contact;

/**
 * @comment This is a Transfer Object which wraps up the profile related
 *          objects.
 * @author andrefabbro
 */
public class UserProfileTO {

	private Contact contact;

	private GeneralProfile generalProfile;

	private MovieInterest movieInterest;

	public Contact getContact() {

		return contact;
	}

	public void setContact(Contact contact) {

		this.contact = contact;
	}

	public GeneralProfile getGeneralProfile() {

		return generalProfile;
	}

	public void setGeneralProfile(GeneralProfile generalProfile) {

		this.generalProfile = generalProfile;
	}

	public MovieInterest getMovieInterest() {

		return movieInterest;
	}

	public void setMovieInterest(MovieInterest movieInterest) {

		this.movieInterest = movieInterest;
	}

}
