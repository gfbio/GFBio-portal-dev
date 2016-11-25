package org.gfbio.idmg.dcrt.dao;

public enum GMaterial {

	BOTANICAL("botanical objects"),
	BOTANICAL_TISSUE("botanical tissue objects"),
	BOTANICAL_DNA("botanical DNA samples"),
	BOTANICAL_ETHANOL("botanical objects in ethanol"),
	BOTANICAL_MICROSCOPIC("botanical microscopic slides"),
    MYCOLOGICAL("mycological objects"),
    MYCOLOGICAL_TISSUE("mycological tissue objects"),
    MYCOLOGICAL_DNA("mycological DNA samples"),
    MYCOLOGICAL_ETHANOL("mycological objects in ethanol"),
    MYCOLOGICAL_MICROSCOPIC("mycological microscopic slides"),
    ZOOLOGICAL("zoological objects"),
    ZOOLOGICAL_TISSUE("zoological tissue objects"),
    ZOOLOGICAL_DNA("zoological DNA samples"),
    ZOOLOGICAL_ETHANOL("zoological objects in ethanol"),
    ZOOLOGICAL_MICROSCOPIC("zoological microscopic slides"),
    PALEONTOLOGICAL("paleontological objects"),
    OTHER_OBJECTS("other objects");
	//Wenn weitere Materialien dazukommen, muss in DCRTPortlet.java eine weitere 
	//If-clause in der Methode setRecommendedProvidersForMaterial() hinzugefügt werden
	
    private final String text;

    /**
     * @param text
     */
    private GMaterial(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
