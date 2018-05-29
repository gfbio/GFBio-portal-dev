package org.gfbio.idmg.jiraclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JiraResponse {

	private long id;
	private String key;
	private String self;
}
