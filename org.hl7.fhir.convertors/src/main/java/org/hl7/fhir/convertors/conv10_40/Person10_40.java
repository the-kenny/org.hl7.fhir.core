package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Person10_40 {

    public static org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LEVEL1:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL1;
            case LEVEL2:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL2;
            case LEVEL3:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL3;
            case LEVEL4:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL4;
            default:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LEVEL1:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL1;
            case LEVEL2:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL2;
            case LEVEL3:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL3;
            case LEVEL4:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL4;
            default:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.dstu2.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasName()) {
            for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_40.convertHumanName(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(src.getBirthDate());
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        }
        if (src.hasPhoto()) {
            tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person tgt = new org.hl7.fhir.dstu2.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasName()) {
            for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_40.convertHumanName(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(src.getBirthDate());
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        }
        if (src.hasPhoto()) {
            tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu2.model.Person.PersonLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        }
        if (src.hasAssurance()) {
            tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu2.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        }
        if (src.hasAssurance()) {
            tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
        }
        return tgt;
    }
}
