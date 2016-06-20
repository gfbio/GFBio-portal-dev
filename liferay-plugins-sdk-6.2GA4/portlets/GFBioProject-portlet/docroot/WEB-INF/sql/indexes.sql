create index IX_1092B488 on gfbio_Project (name);
create index IX_CE661D7B on gfbio_Project (projectID);

create index IX_9CA790C8 on gfbio_Project_ResearchObject (projectID);
create index IX_D3733A45 on gfbio_Project_ResearchObject (researchobjectID);

create index IX_71388715 on gfbio_ResearchObject (name);

create index IX_AD4696FD on gfbio_tab_ResearchObject (ro_name);