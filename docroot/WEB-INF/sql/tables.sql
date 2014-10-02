create table UserProfile_GeneralProfile (
	generalProfileId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	aboutMe TEXT null,
	favoriteQuotes TEXT null
);

create table UserProfile_MovieInterest (
	movieInterestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	favoriteMovie VARCHAR(500) null,
	favoriteGenre VARCHAR(75) null,
	leastFavMovie VARCHAR(500) null,
	favoriteActor VARCHAR(100) null
);