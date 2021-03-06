package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class CareTeam30_40 {

    public static org.hl7.fhir.dstu3.model.CareTeam convertCareTeam(org.hl7.fhir.r4.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam tgt = new org.hl7.fhir.dstu3.model.CareTeam();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertCareTeamStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasManagingOrganization()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CareTeam convertCareTeam(org.hl7.fhir.dstu3.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CareTeam tgt = new org.hl7.fhir.r4.model.CareTeam();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertCareTeamStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasManagingOrganization()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRoleFirstRep()));
        if (src.hasMember())
            tgt.setMember(VersionConvertor_30_40.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(VersionConvertor_30_40.convertReference(src.getOnBehalfOf()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.addRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        if (src.hasMember())
            tgt.setMember(VersionConvertor_30_40.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(VersionConvertor_30_40.convertReference(src.getOnBehalfOf()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus convertCareTeamStatus(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.CareTeam.CareTeamStatus convertCareTeamStatus(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.NULL;
        }
    }
}
