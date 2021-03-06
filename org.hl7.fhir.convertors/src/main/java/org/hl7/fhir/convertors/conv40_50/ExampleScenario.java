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
public class ExampleScenario extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r4.model.ExampleScenario src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario tgt = new org.hl7.fhir.r5.model.ExampleScenario();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        }
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasActor()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor()) tgt.addActor(convertExampleScenarioActorComponent(t));
        }
        if (src.hasInstance()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance()) tgt.addInstance(convertExampleScenarioInstanceComponent(t));
        }
        if (src.hasProcess()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess()) tgt.addProcess(convertExampleScenarioProcessComponent(t));
        }
        if (src.hasWorkflow()) {
            for (org.hl7.fhir.r4.model.CanonicalType t : src.getWorkflow()) tgt.getWorkflow().add(convertCanonical(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r5.model.ExampleScenario src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario tgt = new org.hl7.fhir.r4.model.ExampleScenario();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        }
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasActor()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor()) tgt.addActor(convertExampleScenarioActorComponent(t));
        }
        if (src.hasInstance()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance()) tgt.addInstance(convertExampleScenarioInstanceComponent(t));
        }
        if (src.hasProcess()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess()) tgt.addProcess(convertExampleScenarioProcessComponent(t));
        }
        if (src.hasWorkflow()) {
            for (org.hl7.fhir.r5.model.CanonicalType t : src.getWorkflow()) tgt.getWorkflow().add(convertCanonical(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent();
        copyElement(src, tgt);
        if (src.hasActorId())
            tgt.setActorIdElement(convertString(src.getActorIdElement()));
        if (src.hasType())
            tgt.setType(convertExampleScenarioActorType(src.getType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent();
        copyElement(src, tgt);
        if (src.hasActorId())
            tgt.setActorIdElement(convertString(src.getActorIdElement()));
        if (src.hasType())
            tgt.setType(convertExampleScenarioActorType(src.getType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType convertExampleScenarioActorType(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSON:
                return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.PERSON;
            case ENTITY:
                return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.ENTITY;
            default:
                return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType convertExampleScenarioActorType(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSON:
                return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.PERSON;
            case ENTITY:
                return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.ENTITY;
            default:
                return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent();
        copyElement(src, tgt);
        if (src.hasResourceId())
            tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
        if (src.hasResourceType())
            tgt.setResourceTypeElement(convertFHIRResourceType(src.getResourceTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasVersion()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion()) tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
        }
        if (src.hasContainedInstance()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance()) tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent();
        copyElement(src, tgt);
        if (src.hasResourceId())
            tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
        if (src.hasResourceType())
            tgt.setResourceTypeElement(convertFHIRResourceType(src.getResourceTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasVersion()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion()) tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
        }
        if (src.hasContainedInstance()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance()) tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeType convertFHIRResourceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType(src.asStringValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> convertFHIRResourceType(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> tgt = new org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType>(new org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceTypeEnumFactory(), src.getCode());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
        copyElement(src, tgt);
        if (src.hasResourceId())
            tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
        copyElement(src, tgt);
        if (src.hasResourceId())
            tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasPreConditions())
            tgt.setPreConditionsElement(convertMarkdown(src.getPreConditionsElement()));
        if (src.hasPostConditions())
            tgt.setPostConditionsElement(convertMarkdown(src.getPostConditionsElement()));
        if (src.hasStep()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep()) tgt.addStep(convertExampleScenarioProcessStepComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasPreConditions())
            tgt.setPreConditionsElement(convertMarkdown(src.getPreConditionsElement()));
        if (src.hasPostConditions())
            tgt.setPostConditionsElement(convertMarkdown(src.getPostConditionsElement()));
        if (src.hasStep()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep()) tgt.addStep(convertExampleScenarioProcessStepComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent();
        copyElement(src, tgt);
        if (src.hasProcess()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess()) tgt.addProcess(convertExampleScenarioProcessComponent(t));
        }
        if (src.hasPause())
            tgt.setPauseElement(convertBoolean(src.getPauseElement()));
        if (src.hasOperation())
            tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
        if (src.hasAlternative()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative()) tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent();
        copyElement(src, tgt);
        if (src.hasProcess()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess()) tgt.addProcess(convertExampleScenarioProcessComponent(t));
        }
        if (src.hasPause())
            tgt.setPauseElement(convertBoolean(src.getPauseElement()));
        if (src.hasOperation())
            tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
        if (src.hasAlternative()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative()) tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
        copyElement(src, tgt);
        if (src.hasNumber())
            tgt.setNumberElement(convertString(src.getNumberElement()));
        if (src.hasType())
            tgt.setTypeElement(convertString(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasInitiator())
            tgt.setInitiatorElement(convertString(src.getInitiatorElement()));
        if (src.hasReceiver())
            tgt.setReceiverElement(convertString(src.getReceiverElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasInitiatorActive())
            tgt.setInitiatorActiveElement(convertBoolean(src.getInitiatorActiveElement()));
        if (src.hasReceiverActive())
            tgt.setReceiverActiveElement(convertBoolean(src.getReceiverActiveElement()));
        if (src.hasRequest())
            tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
        copyElement(src, tgt);
        if (src.hasNumber())
            tgt.setNumberElement(convertString(src.getNumberElement()));
        if (src.hasType())
            tgt.setTypeElement(convertString(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasInitiator())
            tgt.setInitiatorElement(convertString(src.getInitiatorElement()));
        if (src.hasReceiver())
            tgt.setReceiverElement(convertString(src.getReceiverElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasInitiatorActive())
            tgt.setInitiatorActiveElement(convertBoolean(src.getInitiatorActiveElement()));
        if (src.hasReceiverActive())
            tgt.setReceiverActiveElement(convertBoolean(src.getReceiverActiveElement()));
        if (src.hasRequest())
            tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasStep()) {
            for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep()) tgt.addStep(convertExampleScenarioProcessStepComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasStep()) {
            for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep()) tgt.addStep(convertExampleScenarioProcessStepComponent(t));
        }
        return tgt;
    }
}
