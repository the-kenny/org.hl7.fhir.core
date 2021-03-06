package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary10_40 {

    public static org.hl7.fhir.dstu2.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Binary tgt = new org.hl7.fhir.dstu2.model.Binary();
        VersionConvertor_10_40.copyResource(src, tgt);
        if (src.hasContentType()) {
            tgt.setContentType(src.getContentType());
        }
        tgt.setContent(src.getContent());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu2.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
        VersionConvertor_10_40.copyResource(src, tgt);
        if (src.hasContentType()) {
            tgt.setContentType(src.getContentType());
        }
        if (src.hasContent()) {
            tgt.setContent(src.getContent());
        }
        return tgt;
    }
}
