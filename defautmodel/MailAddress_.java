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

import defaultroot.defautmodel.domain.defautmodel.MailContent;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.MailBatch;

@StaticMetamodel(MailAddress.class)
public class MailAddress_ {

    public static volatile SingularAttribute<MailAddress, Integer> mailAddressId;

    public static volatile SingularAttribute<MailAddress, String> recipientMail;
    public static volatile SingularAttribute<MailAddress, String> mailStatus;
    public static volatile SingularAttribute<MailAddress, Integer> retries;
    public static volatile SingularAttribute<MailAddress, Integer> priority;
    public static volatile SingularAttribute<MailAddress, Timestamp> queuedAt;
    public static volatile SingularAttribute<MailAddress, Timestamp> lastTriedAt;
    public static volatile SingularAttribute<MailAddress, Timestamp> sentAt;
    public static volatile SingularAttribute<MailAddress, Timestamp> onHoldUntil;


    public static volatile SingularAttribute<MailAddress, MailContent> mailContentId;
    public static volatile SingularAttribute<MailAddress, Integer> mailContentId_;

    public static volatile SingularAttribute<MailAddress, User> userIdSender;
    public static volatile SingularAttribute<MailAddress, Integer> userIdSender_;

    public static volatile SingularAttribute<MailAddress, User> userIdRecipient;
    public static volatile SingularAttribute<MailAddress, Integer> userIdRecipient_;

    public static volatile SingularAttribute<MailAddress, MailBatch> mailBatchId;
    public static volatile SingularAttribute<MailAddress, Integer> mailBatchId_;



}
