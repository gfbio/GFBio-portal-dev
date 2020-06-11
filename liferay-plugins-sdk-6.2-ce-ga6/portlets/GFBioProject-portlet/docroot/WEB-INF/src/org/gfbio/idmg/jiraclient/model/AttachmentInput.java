package org.gfbio.idmg.jiraclient.model;

import java.io.InputStream;

public class AttachmentInput {
    private final InputStream in;
    private final String filename;

    public AttachmentInput(String filename, InputStream in) {
        this.filename = filename;
        this.in = in;
    }

    public InputStream getInputStream() {
        return in;
    }

    public String getFilename() {
        return filename;
    }
}
