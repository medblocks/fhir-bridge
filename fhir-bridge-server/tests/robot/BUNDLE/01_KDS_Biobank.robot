# Copyright (c) 2021 Peter Wohlfarth (Appsfactory GmbH), Wladislaw Wagner (Vitasystems GmbH),
# Dave Petzold (Appsfactory GmbH) & Pauline Schulz (Appsfactory GmbH)
#
# This file is part of Project EHRbase
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.



*** Settings ***
Resource                ${EXECDIR}/robot/_resources/suite_settings.robot

#Test Setup              generic.prepare new request session    Prefer=return=representation
#...															   Authorization=${AUTHORIZATION['Authorization']}

Force Tags              bundle_create    create



*** Variables ***




*** Test Cases ***

001 Create KDS Biobank FHIR Bundle
    [Documentation]         1. *CREATE* new EHR record\n\n
        ...                 2. *CREATE* FHIR bundle kds_biobank_bundle.json and post it to FHIR server\n\n
    	...                 3. *VALIDATE* the FHIR response status\n\n
        ...                 4. *CREATE* openEHR AQL and post it to openEHR server\n\n
    	...                 5. *VALIDATE* the content of the AQL response.
    [Tags]             	kds-biobank-fhir-bundle    valid   not-ready    not-implemented

	ehr.create new ehr    000_ehr_status.json
    kdsbiobank.create fhir bundle    KDS Biobank    kds_biobank_bundle.json
    kdsbiobank.validate response - 201

    kdsbiobank.create openehr aql    kds_person
    kdsbiobank.validate content response_aql - 201