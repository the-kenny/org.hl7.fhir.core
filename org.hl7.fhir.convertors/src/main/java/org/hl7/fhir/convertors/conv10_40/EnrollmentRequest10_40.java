package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentRequest10_40 {

    public static org.hl7.fhir.r4.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu2.model.EnrollmentRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.EnrollmentRequest tgt = new org.hl7.fhir.r4.model.EnrollmentRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setCreated(src.getCreated());
        tgt.setProvider(VersionConvertor_10_40.convertReference(src.getProvider()));
        tgt.setCandidate(VersionConvertor_10_40.convertReference(src.getSubject()));
        tgt.setCoverage(VersionConvertor_10_40.convertReference(src.getCoverage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.r4.model.EnrollmentRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu2.model.EnrollmentRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setCreated(src.getCreated());
        tgt.setCoverage(VersionConvertor_10_40.convertReference(src.getCoverage()));
        return tgt;
    }
}