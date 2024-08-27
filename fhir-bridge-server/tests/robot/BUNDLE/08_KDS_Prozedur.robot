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


Force Tags              bundle_create    create



*** Variables ***




*** Test Cases ***
001 Create KDS Prozedur FHIR Bundle
    [Documentation]         1. *CREATE* new EHR record\n\n
        ...                 2. *LOAD* KDS_PROZEDUR_FHIR_BUNDLE.json_\n\n
    	...                 3. *UPDATE* ``Subject - Identifier - value`` with the _UUID:_ ${subject_id} which was created in EHR record\n\n
        ...                 4. *POST* example JSON to observation endpoint\n\n
    	...                 5. *VALIDATE* the response status
    [Tags]             	kds-prozedur-fhir-bundle    valid   not-ready    not-implemented

	ehr.create new ehr    000_ehr_status.json
    kdsprozedur.create fhir bundle    KDS Prozedur    kds_prozedur_bundle.json
    kdsprozedur.validate response - 201

    kdsprozedur.create openehr aql    kds_person
    kdsprozedur.validate content response_aql - 201