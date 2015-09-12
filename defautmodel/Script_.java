/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2015/08/04 AD at 17:45:44 PKT
*/
package defaultroot.defautmodel.domain.defautmodel;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.ScriptType;
import defaultroot.defautmodel.domain.defautmodel.ScriptStatus;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.Competence;

@StaticMetamodel(Script.class)
public class Script_ {

    public static volatile SingularAttribute<Script, Integer> scriptId;

    public static volatile SingularAttribute<Script, Boolean> priority;
    public static volatile SingularAttribute<Script, Timestamp> deadline;
    public static volatile SingularAttribute<Script, String> scriptRequest;
    public static volatile SingularAttribute<Script, String> scriptResult;


    public static volatile SingularAttribute<Script, User> clientId;
    public static volatile SingularAttribute<Script, Integer> clientId_;

    public static volatile SingularAttribute<Script, User> scriptorId;
    public static volatile SingularAttribute<Script, Integer> scriptorId_;

    public static volatile SingularAttribute<Script, Language> iso6392t;
    public static volatile SingularAttribute<Script, String> iso6392t_;

    public static volatile SingularAttribute<Script, Translation> translationId;
    public static volatile SingularAttribute<Script, Integer> translationId_;

    public static volatile SingularAttribute<Script, Rating> ratingIdRequest;
    public static volatile SingularAttribute<Script, Integer> ratingIdRequest_;

    public static volatile SingularAttribute<Script, Rating> ratingIdScriptor;
    public static volatile SingularAttribute<Script, Integer> ratingIdScriptor_;

    public static volatile SingularAttribute<Script, Price> priceId;
    public static volatile SingularAttribute<Script, Integer> priceId_;

    public static volatile SingularAttribute<Script, ScriptType> scriptTypeId;
    public static volatile SingularAttribute<Script, Integer> scriptTypeId_;

    public static volatile SingularAttribute<Script, ScriptStatus> scriptStatusId;
    public static volatile SingularAttribute<Script, Integer> scriptStatusId_;

    public static volatile SingularAttribute<Script, Rating> ratingIdClient;
    public static volatile SingularAttribute<Script, Integer> ratingIdClient_;


    public static volatile SetAttribute<Script, Competence> competenceViaScriptCompetenceByCompetenceId;

}
