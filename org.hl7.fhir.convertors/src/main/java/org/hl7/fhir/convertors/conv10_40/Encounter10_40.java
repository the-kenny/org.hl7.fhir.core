package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Encounter10_40 {

    public static org.hl7.fhir.dstu2.model.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter tgt = new org.hl7.fhir.dstu2.model.Encounter();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEncounterState(src.getStatus()));
        }
        if (src.hasClass_()) {
            tgt.setClass_(convertEncounterClass(src.getClass_()));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasPriority()) {
            tgt.setPriority(VersionConvertor_10_40.convertCodeableConcept(src.getPriority()));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_40.convertReference(src.getSubject()));
        }
        if (src.hasEpisodeOfCare()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addIncomingReferral(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        }
        if (src.hasAppointment()) {
            tgt.setAppointment(VersionConvertor_10_40.convertReference(src.getAppointmentFirstRep()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        if (src.hasLength()) {
            tgt.setLength(VersionConvertor_10_40.convertDuration(src.getLength()));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasHospitalization()) {
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        }
        if (src.hasServiceProvider()) {
            tgt.setServiceProvider(VersionConvertor_10_40.convertReference(src.getServiceProvider()));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_40.convertReference(src.getPartOf()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.dstu2.model.Encounter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEncounterState(src.getStatus()));
        }
        if (src.hasClass_()) {
            tgt.setClass_(convertEncounterClass(src.getClass_()));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasPriority()) {
            tgt.setPriority(VersionConvertor_10_40.convertCodeableConcept(src.getPriority()));
        }
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getPatient()));
        }
        if (src.hasEpisodeOfCare()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasIncomingReferral()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getIncomingReferral()) tgt.addBasedOn(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        }
        if (src.hasAppointment()) {
            tgt.addAppointment(VersionConvertor_10_40.convertReference(src.getAppointment()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        if (src.hasLength()) {
            tgt.setLength(VersionConvertor_10_40.convertDuration(src.getLength()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasHospitalization()) {
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        }
        if (src.hasServiceProvider()) {
            tgt.setServiceProvider(VersionConvertor_10_40.convertReference(src.getServiceProvider()));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_40.convertReference(src.getPartOf()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coding convertEncounterClass(org.hl7.fhir.dstu2.model.Encounter.EncounterClass src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPATIENT:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("IMP");
            case OUTPATIENT:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
            case AMBULATORY:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
            case EMERGENCY:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("EMER");
            case HOME:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("HH");
            case FIELD:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("FLD");
            case DAYTIME:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("SS");
            case VIRTUAL:
                return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("VR");
            default:
                return null;
        }
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterClass convertEncounterClass(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src.getSystem().equals("http://terminology.hl7.org/v3/ActCode")) {
            if (src.getCode().equals("IMP"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.INPATIENT;
            if (src.getCode().equals("AMB"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.AMBULATORY;
            if (src.getCode().equals("EMER"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.EMERGENCY;
            if (src.getCode().equals("HH"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.HOME;
            if (src.getCode().equals("FLD"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.FIELD;
            if (src.getCode().equals(""))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.DAYTIME;
            if (src.getCode().equals("VR"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.VIRTUAL;
        }
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.NULL;
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier()) {
            tgt.setPreAdmissionIdentifier(VersionConvertor_10_40.convertIdentifier(src.getPreAdmissionIdentifier()));
        }
        if (src.hasOrigin()) {
            tgt.setOrigin(VersionConvertor_10_40.convertReference(src.getOrigin()));
        }
        if (src.hasAdmitSource()) {
            tgt.setAdmitSource(VersionConvertor_10_40.convertCodeableConcept(src.getAdmitSource()));
        }
        if (src.hasReAdmission()) {
            tgt.setReAdmission(VersionConvertor_10_40.convertCodeableConcept(src.getReAdmission()));
        }
        if (src.hasDietPreference()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialCourtesy()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialArrangement()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_40.convertReference(src.getDestination()));
        }
        if (src.hasDischargeDisposition()) {
            tgt.setDischargeDisposition(VersionConvertor_10_40.convertCodeableConcept(src.getDischargeDisposition()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier()) {
            tgt.setPreAdmissionIdentifier(VersionConvertor_10_40.convertIdentifier(src.getPreAdmissionIdentifier()));
        }
        if (src.hasOrigin()) {
            tgt.setOrigin(VersionConvertor_10_40.convertReference(src.getOrigin()));
        }
        if (src.hasAdmitSource()) {
            tgt.setAdmitSource(VersionConvertor_10_40.convertCodeableConcept(src.getAdmitSource()));
        }
        if (src.hasReAdmission()) {
            tgt.setReAdmission(VersionConvertor_10_40.convertCodeableConcept(src.getReAdmission()));
        }
        if (src.hasDietPreference()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialCourtesy()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialArrangement()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_40.convertReference(src.getDestination()));
        }
        if (src.hasDischargeDisposition()) {
            tgt.setDischargeDisposition(VersionConvertor_10_40.convertCodeableConcept(src.getDischargeDisposition()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_40.convertReference(src.getLocation()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEncounterLocationStatus(src.getStatus()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_40.convertReference(src.getLocation()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEncounterLocationStatus(src.getStatus()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus convertEncounterLocationStatus(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.PLANNED;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.ACTIVE;
            case RESERVED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.RESERVED;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.COMPLETED;
            default:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus convertEncounterLocationStatus(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.PLANNED;
            case ACTIVE:
                return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.ACTIVE;
            case RESERVED:
                return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.RESERVED;
            case COMPLETED:
                return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.COMPLETED;
            default:
                return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        if (src.hasIndividual()) {
            tgt.setIndividual(VersionConvertor_10_40.convertReference(src.getIndividual()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        if (src.hasIndividual()) {
            tgt.setIndividual(VersionConvertor_10_40.convertReference(src.getIndividual()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterState convertEncounterState(org.hl7.fhir.r4.model.Encounter.EncounterStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.PLANNED;
            case ARRIVED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.ARRIVED;
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.INPROGRESS;
            case ONLEAVE:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.ONLEAVE;
            case FINISHED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.Encounter.EncounterState.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterStatus convertEncounterState(org.hl7.fhir.dstu2.model.Encounter.EncounterState src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.PLANNED;
            case ARRIVED:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.ARRIVED;
            case INPROGRESS:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.INPROGRESS;
            case ONLEAVE:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.ONLEAVE;
            case FINISHED:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.CANCELLED;
            default:
                return org.hl7.fhir.r4.model.Encounter.EncounterStatus.NULL;
        }
    }
}
