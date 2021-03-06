package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.convertors.VersionConvertor_40_50;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Appointment extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.r4.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasCancelationReason())
            tgt.setCancelationReason(convertCodeableConcept(src.getCancelationReason()));
        if (src.hasServiceCategory()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceCategory()) tgt.addServiceCategory(convertCodeableConcept(t));
        }
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        }
        if (src.hasAppointmentType())
            tgt.setAppointmentType(convertCodeableConcept(src.getAppointmentType()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        }
        if (src.hasPriority())
            tgt.setPriorityElement(convertUnsignedInt(src.getPriorityElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        }
        if (src.hasStart())
            tgt.setStartElement(convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertInstant(src.getEndElement()));
        if (src.hasMinutesDuration())
            tgt.setMinutesDurationElement(convertPositiveInt(src.getMinutesDurationElement()));
        if (src.hasSlot()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSlot()) tgt.addSlot(convertReference(t));
        }
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        }
        if (src.hasRequestedPeriod()) {
            for (org.hl7.fhir.r4.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(convertPeriod(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment tgt = new org.hl7.fhir.r4.model.Appointment();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasCancelationReason())
            tgt.setCancelationReason(convertCodeableConcept(src.getCancelationReason()));
        if (src.hasServiceCategory()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceCategory()) tgt.addServiceCategory(convertCodeableConcept(t));
        }
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        }
        if (src.hasAppointmentType())
            tgt.setAppointmentType(convertCodeableConcept(src.getAppointmentType()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertUnsignedInt(src.getPriorityElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        }
        if (src.hasStart())
            tgt.setStartElement(convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertInstant(src.getEndElement()));
        if (src.hasMinutesDuration())
            tgt.setMinutesDurationElement(convertPositiveInt(src.getMinutesDurationElement()));
        if (src.hasSlot()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(convertReference(t));
        }
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        }
        if (src.hasRequestedPeriod()) {
            for (org.hl7.fhir.r5.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(convertPeriod(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.r4.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NOSHOW;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ENTEREDINERROR;
            case CHECKEDIN:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CHECKEDIN;
            case WAITLIST:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.WAITLIST;
            default:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.r5.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NOSHOW;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ENTEREDINERROR;
            case CHECKEDIN:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.CHECKEDIN;
            case WAITLIST:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.WAITLIST;
            default:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        }
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        }
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.r4.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.r5.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ParticipationStatus convertParticipationStatus(org.hl7.fhir.r4.model.Appointment.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NULL;
        }
    }
}
