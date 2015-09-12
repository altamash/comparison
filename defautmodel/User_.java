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

import defaultroot.defautmodel.domain.defautmodel.LanguageSkill;
import defaultroot.defautmodel.domain.defautmodel.MailAddress;
import defaultroot.defautmodel.domain.defautmodel.MailAddress;
import defaultroot.defautmodel.domain.defautmodel.Revinfo;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.TranslationSkill;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Country;
import defaultroot.defautmodel.domain.defautmodel.App;
import defaultroot.defautmodel.domain.defautmodel.Competence;
import defaultroot.defautmodel.domain.defautmodel.Role;

@StaticMetamodel(User.class)
public class User_ {

    public static volatile SingularAttribute<User, Integer> userId;

    public static volatile SingularAttribute<User, String> salutation;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> street;
    public static volatile SingularAttribute<User, String> postalCode;
    public static volatile SingularAttribute<User, String> city;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> initialUserType;
    public static volatile SingularAttribute<User, String> registrationLink;
    public static volatile SingularAttribute<User, String> host;
    public static volatile SingularAttribute<User, String> ip;
    public static volatile SingularAttribute<User, Boolean> acceptedTacScriptor;
    public static volatile SingularAttribute<User, Boolean> acceptedTacClient;
    public static volatile SingularAttribute<User, Boolean> isActive;
    public static volatile SingularAttribute<User, Boolean> isDeleted;
    public static volatile SingularAttribute<User, Timestamp> createdAt;


    public static volatile SingularAttribute<User, Language> appLanguage;
    public static volatile SingularAttribute<User, String> appLanguage_;

    public static volatile SingularAttribute<User, Country> isoalpha3;
    public static volatile SingularAttribute<User, String> isoalpha3_;

    public static volatile SingularAttribute<User, App> appSourceKey;
    public static volatile SingularAttribute<User, String> appSourceKey_;

    public static volatile SetAttribute<User, LanguageSkill> languageSkillUserViaUserId;
    public static volatile SetAttribute<User, MailAddress> mailAddressUserViaUserIdSender;
    public static volatile SetAttribute<User, MailAddress> mailAddressUserViaUserIdRecipient;
    public static volatile SetAttribute<User, Revinfo> revinfoUserViaUserId;
    public static volatile SetAttribute<User, Script> scriptUserViaClientId;
    public static volatile SetAttribute<User, Script> scriptUserViaScriptorId;
    public static volatile SetAttribute<User, TranslationSkill> translationSkillUserViaUserId;

    public static volatile SetAttribute<User, Competence> competenceViaUserCompetenceByCompetenceId;
    public static volatile SetAttribute<User, Role> roleViaUserRoleByRoleId;

}
