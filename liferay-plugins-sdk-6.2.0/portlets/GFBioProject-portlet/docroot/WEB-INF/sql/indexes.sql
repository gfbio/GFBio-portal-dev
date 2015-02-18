create index IX_1092B488 on gfbio_Project (name);
create index IX_CE661D7B on gfbio_Project (projectID);

create index IX_9CA790C8 on gfbio_Project_ResearchObject (projectID);
create index IX_D3733A45 on gfbio_Project_ResearchObject (researchobjectID);

create index IX_E483BDAD on gfbio_Project_User_PI (projectID);
create index IX_D16D3B1 on gfbio_Project_User_PI (userID);

create index IX_2DE6828 on gfbio_Project_User_Worker (projectID);
create index IX_B709B316 on gfbio_Project_User_Worker (userID);

create index IX_71388715 on gfbio_ResearchObject (name);

create index IX_AD4696FD on gfbio_tab_ResearchObject (ro_name);