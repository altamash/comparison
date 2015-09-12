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

import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.TranslationSkill;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Language;

@StaticMetamodel(Translation.class)
public class Translation_ {

    public static volatile SingularAttribute<Translation, Integer> translationId;

    public static volatile SingularAttribute<Translation, Boolean> isActive;


    public static volatile SingularAttribute<Translation, Language> iso6392tFrom;
    public static volatile SingularAttribute<Translation, String> iso6392tFrom_;

    public static volatile SingularAttribute<Translation, Language> iso6392tTo;
    public static volatile SingularAttribute<Translation, String> iso6392tTo_;

    public static volatile SetAttribute<Translation, Price> priceTranslationViaTranslationId;
    public static volatile SetAttribute<Translation, Script> scriptTranslationViaTranslationId;
    public static volatile SetAttribute<Translation, TranslationSkill> translationSkillTranslationViaTranslationId;


}
