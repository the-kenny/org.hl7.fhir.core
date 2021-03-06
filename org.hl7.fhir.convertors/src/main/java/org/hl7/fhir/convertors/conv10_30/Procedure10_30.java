package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Procedure10_30 {

    public static org.hl7.fhir.dstu2.model.Procedure convertProcedure(org.hl7.fhir.dstu3.model.Procedure src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Procedure tgt = new org.hl7.fhir.dstu2.model.Procedure();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertProcedureStatus(src.getStatus()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasNotDone()) {
            tgt.setNotPerformed(src.getNotDone());
        }
        if (src.hasNotDoneReason()) {
            tgt.addReasonNotPerformed(VersionConvertor_10_30.convertCodeableConcept(src.getNotDoneReason()));
        }
        if (src.hasBodySite()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasReasonCode()) {
            tgt.setReason(VersionConvertor_10_30.convertType(src.getReasonCodeFirstRep()));
        }
        if (src.hasPerformer()) {
            for (org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertProcedurePerformerComponent(t));
        }
        if (src.hasPerformed()) {
            tgt.setPerformed(VersionConvertor_10_30.convertType(src.getPerformed()));
        }
        if (src.hasContext()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasOutcome()) {
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        }
        if (src.hasReport()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReport()) tgt.addReport(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasComplication()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getComplication()) tgt.addComplication(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasFollowUp()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getFollowUp()) tgt.addFollowUp(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasBasedOn()) {
            tgt.setRequest(VersionConvertor_10_30.convertReference(src.getBasedOnFirstRep()));
        }
        if (src.hasFocalDevice()) {
            for (org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice()) tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Procedure convertProcedure(org.hl7.fhir.dstu2.model.Procedure src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Procedure tgt = new org.hl7.fhir.dstu3.model.Procedure();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertProcedureStatus(src.getStatus()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasNotPerformed()) {
            tgt.setNotDone(src.getNotPerformed());
        }
        if (src.hasReasonNotPerformed())
            tgt.setNotDoneReason(VersionConvertor_10_30.convertCodeableConcept(src.getReasonNotPerformed().get(0)));
        if (src.hasBodySite()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasReasonCodeableConcept())
            tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(src.getReasonCodeableConcept()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertProcedurePerformerComponent(t));
        }
        if (src.hasPerformed()) {
            tgt.setPerformed(VersionConvertor_10_30.convertType(src.getPerformed()));
        }
        if (src.hasEncounter()) {
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasOutcome()) {
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        }
        if (src.hasReport()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getReport()) tgt.addReport(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasComplication()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getComplication()) tgt.addComplication(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasFollowUp()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getFollowUp()) tgt.addFollowUp(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasRequest()) {
            tgt.addBasedOn(VersionConvertor_10_30.convertReference(src.getRequest()));
        }
        if (src.hasFocalDevice()) {
            for (org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice()) tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            tgt.setAction(VersionConvertor_10_30.convertCodeableConcept(src.getAction()));
        }
        if (src.hasManipulated()) {
            tgt.setManipulated(VersionConvertor_10_30.convertReference(src.getManipulated()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            tgt.setAction(VersionConvertor_10_30.convertCodeableConcept(src.getAction()));
        }
        if (src.hasManipulated()) {
            tgt.setManipulated(VersionConvertor_10_30.convertReference(src.getManipulated()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasActor()) {
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        }
        if (src.hasRole()) {
            tgt.setRole(VersionConvertor_10_30.convertCodeableConcept(src.getRole()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasActor()) {
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        }
        if (src.hasRole()) {
            tgt.setRole(VersionConvertor_10_30.convertCodeableConcept(src.getRole()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus convertProcedureStatus(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.INPROGRESS;
            case ABORTED:
                return org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ABORTED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus convertProcedureStatus(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.INPROGRESS;
            case ABORTED:
                return org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.ABORTED;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.NULL;
        }
    }
}
