package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Patient10_40 {

    public static org.hl7.fhir.r4.model.Extension convertAnimalComponent(org.hl7.fhir.dstu2.model.Patient.AnimalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        tgt.setUrl("http://hl7.org/fhir/StructureDefinition/patient-animal");
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasSpecies())
            tgt.addExtension("species", VersionConvertor_10_40.convertCodeableConcept(src.getSpecies()));
        if (src.hasBreed())
            tgt.addExtension("breed", VersionConvertor_10_40.convertCodeableConcept(src.getBreed()));
        if (src.hasGenderStatus())
            tgt.addExtension("genderStatus", VersionConvertor_10_40.convertCodeableConcept(src.getGenderStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu2.model.Patient.AnimalComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasExtension("species"))
            tgt.setSpecies(VersionConvertor_10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("species").getValue()));
        if (src.hasExtension("breed"))
            tgt.setBreed(VersionConvertor_10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("breed").getValue()));
        if (src.hasExtension("genderStatus"))
            tgt.setGenderStatus(VersionConvertor_10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("genderStatus").getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu2.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasRelationship()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_40.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_40.convertAddress(src.getAddress()));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasOrganization()) {
            tgt.setOrganization(VersionConvertor_10_40.convertReference(src.getOrganization()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu2.model.Patient.ContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasRelationship()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_40.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_40.convertAddress(src.getAddress()));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasOrganization()) {
            tgt.setOrganization(VersionConvertor_10_40.convertReference(src.getOrganization()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.LinkType convertLinkType(org.hl7.fhir.dstu2.model.Patient.LinkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACE:
                return org.hl7.fhir.r4.model.Patient.LinkType.REPLACEDBY;
            case REFER:
                return org.hl7.fhir.r4.model.Patient.LinkType.REFER;
            case SEEALSO:
                return org.hl7.fhir.r4.model.Patient.LinkType.SEEALSO;
            default:
                return org.hl7.fhir.r4.model.Patient.LinkType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Patient.LinkType convertLinkType(org.hl7.fhir.r4.model.Patient.LinkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACEDBY:
                return org.hl7.fhir.dstu2.model.Patient.LinkType.REPLACE;
            case REPLACES:
                return org.hl7.fhir.dstu2.model.Patient.LinkType.REPLACE;
            case REFER:
                return org.hl7.fhir.dstu2.model.Patient.LinkType.REFER;
            case SEEALSO:
                return org.hl7.fhir.dstu2.model.Patient.LinkType.SEEALSO;
            default:
                return org.hl7.fhir.dstu2.model.Patient.LinkType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.dstu2.model.Patient src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
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
        if (src.hasDeceased()) {
            tgt.setDeceased(VersionConvertor_10_40.convertType(src.getDeceased()));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        }
        if (src.hasMaritalStatus()) {
            tgt.setMaritalStatus(VersionConvertor_10_40.convertCodeableConcept(src.getMaritalStatus()));
        }
        if (src.hasMultipleBirth()) {
            tgt.setMultipleBirth(VersionConvertor_10_40.convertType(src.getMultipleBirth()));
        }
        if (src.hasPhoto()) {
            for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_40.convertAttachment(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        }
        if (src.hasAnimal())
            tgt.addExtension(convertAnimalComponent(src.getAnimal()));
        if (src.hasCommunication()) {
            for (org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        }
        if (src.hasCareProvider()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getCareProvider()) tgt.addGeneralPractitioner(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient tgt = new org.hl7.fhir.dstu2.model.Patient();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
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
        if (src.hasDeceased()) {
            tgt.setDeceased(VersionConvertor_10_40.convertType(src.getDeceased()));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        }
        if (src.hasMaritalStatus()) {
            tgt.setMaritalStatus(VersionConvertor_10_40.convertCodeableConcept(src.getMaritalStatus()));
        }
        if (src.hasMultipleBirth()) {
            tgt.setMultipleBirth(VersionConvertor_10_40.convertType(src.getMultipleBirth()));
        }
        if (src.hasPhoto()) {
            for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_40.convertAttachment(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        }
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/patient-animal"))
            tgt.setAnimal(convertAnimalComponent(src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/patient-animal")));
        if (src.hasCommunication()) {
            for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        }
        if (src.hasGeneralPractitioner()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner()) tgt.addCareProvider(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLanguage()) {
            tgt.setLanguage(VersionConvertor_10_40.convertCodeableConcept(src.getLanguage()));
        }
        if (src.hasPreferred()) {
            tgt.setPreferred(src.getPreferred());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLanguage()) {
            tgt.setLanguage(VersionConvertor_10_40.convertCodeableConcept(src.getLanguage()));
        }
        if (src.hasPreferred()) {
            tgt.setPreferred(src.getPreferred());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasOther()) {
            tgt.setOther(VersionConvertor_10_40.convertReference(src.getOther()));
        }
        if (src.hasType()) {
            tgt.setType(convertLinkType(src.getType()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasOther()) {
            tgt.setOther(VersionConvertor_10_40.convertReference(src.getOther()));
        }
        if (src.hasType()) {
            tgt.setType(convertLinkType(src.getType()));
        }
        return tgt;
    }
}
