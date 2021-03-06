package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner10_30 {

    public static org.hl7.fhir.dstu3.model.Practitioner convertPractitioner(org.hl7.fhir.dstu2.model.Practitioner src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Practitioner tgt = new org.hl7.fhir.dstu3.model.Practitioner();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasName())
            tgt.addName(VersionConvertor_10_30.convertHumanName(src.getName()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(src.getBirthDate());
        }
        if (src.hasPhoto()) {
            for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        }
        if (src.hasQualification()) {
            for (org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        }
        if (src.hasCommunication()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Practitioner convertPractitioner(org.hl7.fhir.dstu3.model.Practitioner src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Practitioner tgt = new org.hl7.fhir.dstu2.model.Practitioner();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasName()) {
            for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.setName(VersionConvertor_10_30.convertHumanName(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(src.getBirthDate());
        }
        if (src.hasPhoto()) {
            for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        }
        if (src.hasQualification()) {
            for (org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        }
        if (src.hasCommunication()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        }
        if (src.hasIssuer()) {
            tgt.setIssuer(VersionConvertor_10_30.convertReference(src.getIssuer()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        }
        if (src.hasIssuer()) {
            tgt.setIssuer(VersionConvertor_10_30.convertReference(src.getIssuer()));
        }
        return tgt;
    }
}
