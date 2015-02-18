create table gfbio_Project (
	projectID LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	begin DATE null,
	end_ DATE null,
	status VARCHAR(75) null
);

create table gfbio_Project_ResearchObject (
	projectID LONG not null,
	researchobjectID LONG not null,
	primary key (projectID, researchobjectID)
);

create table gfbio_Project_User_PI (
	projectID LONG not null,
	userID LONG not null,
	begin DATE null,
	end_ DATE null,
	primary key (projectID, userID)
);

create table gfbio_Project_User_Worker (
	projectID LONG not null,
	userID LONG not null,
	begin DATE null,
	end_ DATE null,
	primary key (projectID, userID)
);

create table gfbio_ResearchObject (
	researchobjectID LONG not null primary key,
	name VARCHAR(75) null,
	metadata VARCHAR(75) null
);

create table gfbio_tab_ResearchObject (
	ro_ID LONG not null primary key,
	ro_name VARCHAR(75) null,
	ro_meta VARCHAR(75) null
);