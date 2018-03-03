# SpecllCheckUtility
Any web application can be checked for Spell check as well as Camel Case, This utility will help us to verify the spelling wrt dictionary defined

Here is how you will be going to use it:-

Just build it with maven with all dependencies and export as runnable Jar which will be taking URL as input

main class : LinkNavigationHelper

Use like GeneratedJar.jar $URL 

You will see logs like below:-

=============================================================================================

java -jar SpellCheckUtil.jar http://google.com/_layouts/application/App/Opportunity/OpportunityPipeline.aspx
Starting ChromeDriver 2.35.528161 (5b82f2d2aae0ca24b877009200ced9065a772e73) on port 48384
Only local connections are allowed.
Feb 28, 2018 9:15:47 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
============================================================================
TOTAL LINK FOUND ON BASE URL : 6
============================================================================
LINK NAME: 'Home' URL is ==>  http://google.com/pages/default.aspx
LINK NAME: '' URL is ==>  http://google.com/_layouts/application/App/Opportunity/OpportunityPipeline.aspx
LINK NAME: '' URL is ==>  http://google.com/_layouts/application/App/Issue/IssuePipeline.aspx
LINK NAME: '' URL is ==>  http://google.com/_layouts/application/App/Opportunity/Opportunity.aspx
LINK NAME: '' URL is ==>  http://google.com/_layouts/application/App/Issue/Issue.aspx
LINK NAME: '' URL is ==>  http://google.com/_layouts/application/App/AppConfig/AppConfig.aspx

*************************************
============================================================================
1: NAVIGATED TO URL with : 'http://google.com/pages/default.aspx'
 RESPONSE CODE: Unauthorized
============================================================================
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                      =========================================
			Total Words Found on URL : 81

                      =========================================
CORRECTION OPTION FOR TEXT 'OPPTY-2017-00035 Applewood Estates dee 1 Interview Open' is : OPPTY-2017-00035 applied Estates Dee 1 Interview Open
CORRECTION OPTION FOR TEXT 'OPPTY-2017-00032 Independent School Dist 485 (Royalton) MN test oppp Time Zone 7.14 AM 6/2/2017 EST Interview Open $45,454 06/02/2017' is : OPPTY-2017-00032 Independent School Dist 485 (Royalton) MN test opp Time Zone 7.14 AM 6/2/2017 EST Interview Open $45,454 06/02/2017
CORRECTION OPTION FOR TEXT 'NEG-2017-00100 Panama-Buena Vista Union School District Ser vs Trans _2 Negotiated Pre-Pricing Lead Banker Approved; Compliance/Legal Approved; Supervisory Principal Approved; Management Approved; Firm Credit Approved $440,000,000 Sole Manager 10/26/2017 10/26/2017 PnL Administrator/Finance Controller Review; PnL Approver Review SER0001; SER0002' is : NEG-2017-00100 Panama-Bean Vista Union School District Sr vs Trans _2 Negotiated Pr-Pricing Lead Banker Approved; Compliance/Legal Approved; Supervisory Principal Approved; Management Approved; Firm Credit Approved $440,000,000 Sole Manager 10/26/2017 10/26/2017 PnL Administrator/Finance Controller Review; PnL Approver Review SER0001; SER0002
CORRECTION OPTION FOR TEXT 'NEG-2017-00094 Bi-State Development Agency of Missouri-Illinois Ser Vs Trans 29/09 Negotiated Active $300 Senior Manager 09/02/2017 09/05/2017 SER1111; SER2222' is : NEG-2017-00094 Bi-State Development Agency of Missouri-Illinois Sr Vs Trans 29/09 Negotiated Active $300 Senior Manager 09/02/2017 09/05/2017 SER1111; SER2222

=============================================================================================
