# jgravatar

jgravatar is a tiny Java library for accessing avatar images from gravatar.com

## Usage example

	Gravatar gravatar = new Gravatar();
	gravatar.setSize(50);
	gravatar.setRating(GravatarRating.GENERAL_AUDIENCES);
	gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
	String url = gravatar.getUrl("iHaveAn@email.com");
	byte[] jpg = gravatar.download("info@ralfebert.de");
