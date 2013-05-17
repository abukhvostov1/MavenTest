package pack_test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.appengine.repackaged.org.json.JSONException;

import pack_connect.ConnectMethod;
import pack_utils.ExceptFailTest;

public class Test_Mobile
{
	ConnectMethod cM = new ConnectMethod();

	// Автоте

/////////////////////////////////////////////////////////////////////////////////////////////////////////// 	
	@Test (groups = { "AutoTest_1" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_CreateProfile(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.CreateProfileReqeust(sBaseHost, sTypeApi); // Создание профиля
	}
	
	@Test (groups = { "AutoTest_2" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_Authorization(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.Authorization(sBaseHost, sTypeApi); // Авторизация	
	}
	
	@Test (groups = { "AutoTest_3" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetAndEditProfile(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.GetAndEditProfile(sBaseHost, sTypeApi); // Получение и редактирование профиля
	}
	
	@Test (groups = { "AutoTest_4"})
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_RestorePassworde(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.RestorePassword(sBaseHost, sTypeApi); // Восстановление пароля
	}
	
	@Test (groups = { "AutoTest_5" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddGetEditAdvertOP(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddGetEditAdvertOP(sBaseHost, sTypeApi); // Подача/получение/редактирование/
	}

	@Test (groups = { "AutoTest_6" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddGetListDeleteOP(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.AddGetListDeleteOP(sBaseHost, sTypeApi);  // подача/получение листинга ЛК/удаление/ получение листинга ЛК 
	}
		
	@Test (groups = { "AutoTest_7" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddFavGetListFavDeleteFavOP(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.AddFavGetListFavDeleteFavOP(sBaseHost, sTypeApi); // Подача/добавление в избранное/удаление из избранного
	}
		
	@Test (groups = { "AutoTest_8" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddDeactivateActivateProlongPushupHighlightPremiumOPFreeAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddDeactivateActivateProlongPushupHighlightPremiumOPFreeAdvert(sBaseHost, sTypeApi); // Подача/деактивация/активация/продление/поднятие/выделение/пермиум бесплатное объявление
	}
	
	
	@Test (groups = { "AutoTest_9" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddDeactivateActivateProlongPushupHighlightPremiumOPPaidAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddDeactivateActivateProlongPushupHighlightPremiumOPPaidAdvert(sBaseHost, sTypeApi); // Подача/деактивация/активация/продление/поднятие/выделение/пермиум платное объявление
	}
	 
	
	@Test (groups = { "AutoTest_10" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddActivateDeactivateProlongPushUpHighLightPremiumIP(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddActivateDeactivateProlongPushUpHighLightPremiumIP(sBaseHost, sTypeApi); //Попытка Подачи/редактирования/деактивации/активация/продление/поднятие/выделение/пермиум ИП
	}
	
	
	@Test (groups = { "AutoTest_11" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddAvdertGetListUserOP(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddAvdertGetListUserOP(sBaseHost, sTypeApi); //Подача/получение листинга объявлений пользователя
	}
	
	
	@Test (groups = { "AutoTest_12" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddGetFilterList(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddGetFilterList(sBaseHost, sTypeApi); //Подача/получение фильтрованного листинга объявлений категории
	}

	
	@Test (groups = { "AutoTest_13" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddVoteHighLower(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddVoteHighLower(sBaseHost, sTypeApi); //Подача/голосование+/голосование-
	}
	
	
	@Test (groups = { "AutoTest_14" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddAdvertGetCitiesGetListCategory(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException
	{
			cM.AddAdvertGetCitiesGetListCategory(sBaseHost, sTypeApi); //Подача/Получение и проверка листинга категории 
	}
	
	
	@Test (groups = { "AutoTest_15" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetAndCheckRubricator(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetAndCheckRubricator(sBaseHost, sTypeApi); //Получение и проверка рубрикатора
	}
	
	@Test (groups = { "AutoTest_16" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetFieldsForAddAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetFieldsForAddAdvert(sBaseHost, sTypeApi); //Получение и проверка полей для подачи 
	}
	
	
	@Test (groups = { "AutoTest_17" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetFieldsForEditAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetFieldsForEditAdvert(sBaseHost, sTypeApi); //Получение и проверка полей для редактирования
	}
	
	
	@Test (groups = { "AutoTest_18" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetFieldsForSearchAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetFieldsForSearchAdvert(sBaseHost, sTypeApi); //Получение и проверка полей для фильтрации
	}
	
	
	@Test (groups = { "AutoTest_19" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetRegionRussionFederation(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetRegionRussionFederation(sBaseHost, sTypeApi); //Получение и проверка списка  регионов РФ
	}
	
	
	@Test (groups = { "AutoTest_20" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetRegionsWithDomen(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetRegionsWithDomen(sBaseHost, sTypeApi); //Получение и проверка списка  регионов c поддоменами
	}
	
	
	@Test (groups = { "AutoTest_21" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetCitiesInsideRegion(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetCitiesInsideRegion(sBaseHost, sTypeApi); //Получение и проверка списка  городов принадлежащих опредлеленному региону
	}
	
	@Test (groups = { "AutoTest_22" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetAllSuggest(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetAllSuggest(sBaseHost, sTypeApi); //Получение и проверка саджествов
	}
	
	@Test (groups = { "AutoTest_23" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetCurrencies(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetCurrencies(sBaseHost, sTypeApi); //Получение и проверка списка валют
	}
	
	
	@Test (groups = { "AutoTest_24" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetDictionary(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetDictionary(sBaseHost, sTypeApi); //Получение и проверка словарей
	}
	
	
	@Test (groups = { "AutoTest_25" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddAdvertCheckPaidAndFreeProducts(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.AddAdvertCheckPaidAndFreeProducts(sBaseHost, sTypeApi); //Получение и проверка платных и бесплатных продуктов на этапе подачи и в ЛК
	}
	
	@Test (groups = { "AutoTest_26" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_GetLinkActivasion(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.GetLinkActivasion(sBaseHost, sTypeApi); //Получение ссылки для активации аккаунта
	}
	
	@Test (groups = { "AutoTest_27" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_ChangePassword(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.ChangePassword(sBaseHost, sTypeApi); //Смена пароля
	}
	
	
	@Test (groups = { "AutoTest_28" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddAndEditWithImage(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.AddAndEditWithImage(sBaseHost, sTypeApi); //Подача объявления без изображения и редактирование с добавлением изображения
	}
	
	@Test (groups = { "AutoTest_29" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_LogoutAndCheckAuthToken(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.LogoutAndCheckAuthToken(sBaseHost, sTypeApi); //Авторизация, логаут, проверка не работоспособности ключа авторизации после логаута(проверяем подачей)
	}
	
	@Test (groups = { "AutoTest_30" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_CheckFavouriteAdvertInListing(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.CheckFavouriteAdvertInListing(sBaseHost, sTypeApi); //Добавление в избранное , получение листинга категории и фильтрации, проверка флага isfavorited
	}
	
	@Test (groups = { "AutoTest_31" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void AutoTest_AddAdvertGetListAndCheckMagicRegion(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, InterruptedException, ClassNotFoundException
	{
			cM.AddAdvertGetListAndCheckMagicRegion(sBaseHost, sTypeApi); //Подача в волшебные регионы(Москва и обл, Санкт-Петербург и обл), получение листинга категории и фильтрации, проверка наличия поданных объявлений
	}
	
	
	
	// Параметризированные тесты
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test (groups = { "CreateProfileRequest_1" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "sMM_Id", "sOD_Id", "sTypeApi"})
	public void Test(String sBaseHost, String sLogin, String sPassword, @Optional("") String sMM_Id, @Optional("") String sOD_Id, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.CreateProfileRequest_1(sBaseHost, sLogin, sPassword, sMM_Id, sOD_Id, sTypeApi);
	}

	@Test (groups = { "Authorization_1_1" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "sMM_Id", "sOD_Id", "sTypeApi"})
	public void Test1(String sBaseHost, String sLogin, String sPassword, @Optional("") String sMM_Id, @Optional("") String sOD_Id, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.Authorization_1_1(sBaseHost, sLogin, sPassword, sMM_Id, sOD_Id, sTypeApi);
	}

	@Test (groups = { "GetProfile_1_2" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "bAuthFlag"})
	public void Test2(String sBaseHost, String sLogin, String sPassword, boolean bAuthFlag) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetProfile_1_2(sBaseHost, sLogin, sPassword, bAuthFlag);
	}
	
	@Test (groups = { "EditProfile_1_3" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sParam", "bAuthFlag", "sTypeApi"})
	public void Test3(String sBaseHost, String sLogin, String sPassword, String sParam, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.EditProfile_1_3(sBaseHost, sLogin, sPassword, sParam, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "RestorePassword1_4" })
	@Parameters({"sBaseHost", "sLogin", "sTypeApi"})
	public void Test4(String sBaseHost, String sLogin, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.RestorePassword1_4(sBaseHost, sLogin, sTypeApi);
	}
	
	@Test (groups = { "ChangePassword1_5" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "sNewPassword", "bAuthFlag", "sTypeApi"})
	public void Test1_5(String sBaseHost, String sLogin, String sPassword, String sNewPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.ChangePassword1_5(sBaseHost, sLogin, sPassword, sNewPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetUrlActivasion_1_6" })
	@Parameters({"sBaseHost", "sLogin", "sTypeApi"})
	public void Test1_6(String sBaseHost, String sLogin, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.GetUrlActivasion_1_6(sBaseHost, sLogin, sTypeApi);
	}
	
	@Test (groups = { "LogOut1_7" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test1_7(String sBaseHost, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
			cM.LogOut1_7(sBaseHost, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "PostAdvert_2_1" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sParam",  "sParam1",  "sParam2", "sVideoUrl", "sPathImageNew", "bAuthFlag", "sTypeApi"})
	public void Test5(String sBaseHost, String sLogin, String sPassword, String sParam, String sParam1, String sParam2, String sVideoUrl,String sPathImageNew, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.PostAdvert_2_1(sBaseHost, sLogin, sPassword, sParam, sParam1, sParam2, sVideoUrl, sPathImageNew, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetAdvert_2_2" })
	@Parameters({"sBaseHost", "sIdAdvert", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test6(String sBaseHost, String sIdAdvert, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetAdvert_2_2(sBaseHost, sIdAdvert, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "EditAdvert_2_3" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "sParam1",   "sParam2", "sPathImageNew", "sVideoUrl",  "bAuthFlag", "bDeleteImage", "sTypeApi"})
	public void Test7(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, String sParam1, String sParam2, String sPathImageNew, String sVideoUrl ,boolean bAuthFlag, boolean bDeleteImage, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.EditAdvert_2_3(sBaseHost, sLogin, sPassword, sIdAdvert, sParam1, sParam2, sPathImageNew, sVideoUrl,  bAuthFlag, bDeleteImage, sTypeApi);
	}
		
	@Test (groups = { "DeleteAdvert_2_4" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test8(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.DeleteAdvert_2_4(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "AddAdvertToFavourite_2_5" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test9(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.AddAdvertToFavourite_2_5(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
		
	@Test (groups = { "DeleteAdvertFromFavourite_2_6" })
	@Parameters({"sBaseHost", "sLogin", "sPassword", "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test10(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.DeleteAdvertFromFavourite_2_6(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetPaidProductsToStepToAdd_2_7" })
	@Parameters({"sBaseHost","sIdAdvert", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test11(String sBaseHost, String sIdAdvert, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetPaidProductsToStepToAdd_2_7(sBaseHost, sIdAdvert, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetPaidProductsFromLK_2_8" })
	@Parameters({"sBaseHost","sIdAdvert", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test12(String sBaseHost, String sIdAdvert, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetPaidProductsFromLK_2_8(sBaseHost, sIdAdvert, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetFreeProductsForAdvert_2_9" })
	@Parameters({"sBaseHost","sIdAdvert", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test13(String sBaseHost, String sIdAdvert, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetFreeProductsForAdvert_2_9(sBaseHost, sIdAdvert, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "ActivationAdvert_2_10" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bApp_token", "bAuthFlag", "sTypeApi"})
	public void Test14(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bApp_token, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.ActivationAdvert_2_10(sBaseHost, sLogin, sPassword, sIdAdvert, bApp_token, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "DeactivateAdvert_2_11" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test15(String sBaseHost, String sLogin, String sPassword, String sIdAdvert,  boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.DeactivateAdvert_2_11(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "Prolongadvert_2_12" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bApp_token", "bAuthFlag", "sTypeApi"})
	public void Test16(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bApp_token, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.Prolongadvert_2_12(sBaseHost, sLogin, sPassword, sIdAdvert, bApp_token, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "PushUpAdvert_2_13" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bApp_token", "bAuthFlag", "sTypeApi"})
	public void Test17(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bApp_token, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.PushUpAdvert_2_13(sBaseHost, sLogin, sPassword, sIdAdvert, bApp_token, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "HighLightAdvert_2_14" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bApp_token", "bAuthFlag", "sTypeApi"})
	public void Test18(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bApp_token, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.HighLightAdvert_2_14(sBaseHost, sLogin, sPassword, sIdAdvert, bApp_token, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "SetPremiumForAdvert_2_15" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bApp_token" , "sNumberDays", "bAuthFlag", "sTypeApi"})
	public void Test19(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bApp_token, String sNumberDays, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.SetPremiumForAdvert_2_15(sBaseHost, sLogin, sPassword, sIdAdvert, bApp_token, sNumberDays, bAuthFlag, sTypeApi);
	}

	@Test (groups = { "VoteForAdvertHigh_2_16" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test20(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.VoteForAdvertHigh_2_16(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "VoteForAdvertLower_2_17" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sIdAdvert", "bAuthFlag", "sTypeApi"})
	public void Test21(String sBaseHost, String sLogin, String sPassword, String sIdAdvert, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.VoteForAdvertLower_2_17(sBaseHost, sLogin, sPassword, sIdAdvert, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetListForCategory_2_18" })
	@Parameters({"sBaseHost", "sParam", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test22(String sBaseHost, String sParam, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListForCategory_2_18(sBaseHost, sParam, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetListSearchCategory_2_19" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test23(String sBaseHost, String sParam, String sParam1, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListSearchCategory_2_19(sBaseHost, sParam, sParam1, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetListFavourite_2_20" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sParam", "bAuthFlag", "sTypeApi"})
	public void Test24(String sBaseHost, String sLogin, String sPassword, String sParam, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListFavourite_2_20(sBaseHost, sLogin, sPassword, sParam, bAuthFlag, sTypeApi);
	
	}
	
	@Test (groups = { "GetListOwnAdvert_2_21" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sParam", "bAuthFlag", "sTypeApi"})
	public void Test25(String sBaseHost, String sLogin, String sPassword, String sParam, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListOwnAdvert_2_21(sBaseHost, sLogin, sPassword, sParam, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetListUserAdvert_2_22" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test26(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListUserAdvert_2_22(sBaseHost, sParam, sTypeApi);
	}
		
	@Test (groups = { "GetRubricator_3_1" })
	@Parameters({"sBaseHost", "sCategory", "sTypeApi"})
	public void Test27(String sBaseHost, String sCategory, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRubricator_3_1(sBaseHost, sCategory, sTypeApi);
	}
	
	@Test (groups = { "GetCastomfieldsForAddAdvert_3_2" })
	@Parameters({"sBaseHost", "sParam", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test28(String sBaseHost, String sParam, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCastomfieldsForAddAdvert_3_2(sBaseHost, sParam, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetCastomfieldsForEditAdvert_3_3" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test29(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCastomfieldsForEditAdvert_3_3(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetCastomfieldsForSearchAdvert_3_4" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test30(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCastomfieldsForSearchAdvert_3_4(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetRegions_4_1" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test31(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRegions_4_1(sBaseHost, sTypeApi);
	}
	
	@Test (groups = { "GetPopularCities_4_2" })
	@Parameters({"sBaseHost", "sRegion", "sTypeApi"})
	public void Test32(String sBaseHost, String sRegion, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetPopularCities_4_2(sBaseHost, sRegion, sTypeApi);
	}
	
	@Test (groups = { "GetCitiesWithDomen_4_2_1" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test32_1(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCitiesWithDomen_4_2_1(sBaseHost, sTypeApi);
	}
	
	@Test (groups = { "GetCitiesSuggest_4_3" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test33(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCitiesSuggest_4_3(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetStreetsSuggest_4_4" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test34(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetStreetsSuggest_4_4(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetHousesSuggest_4_5" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test35(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetHousesSuggest_4_5(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetDistrictSuggest_4_6" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test36(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetDistrictSuggest_4_6(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetMicroDistrictSuggest_4_8" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test36_1(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetMicroDistrictSuggest_4_8(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetAOSuggest_4_9" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test36_2(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetAOSuggest_4_9(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetDirectionSuggest_4_10" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test37(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetDirectionSuggest_4_10(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetHighwaySuggest_4_11" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test38(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetHighwaySuggest_4_11(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetMetroSuggest_4_12" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test39(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetMetroSuggest_4_12(sBaseHost, sParam, sTypeApi);
	}
	
	@Test (groups = { "GetCurrencies_5_1" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test40(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetCurrencies_5_1(sBaseHost, sTypeApi);
	} 
	
	@Test (groups = { "GetDictinary_6_1" })
	@Parameters({"sBaseHost", "sNameDictinary", "sParam", "sTypeApi"})
	public void Test41(String sBaseHost, String sNameDictinary, @Optional("") String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetDictinary_6_1(sBaseHost, sNameDictinary, sParam, sTypeApi);
		//"Car makers commercial"
	} 
	
	@Test (groups = { "GetPromo7_1" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test42(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetPromo7_1(sBaseHost, sParam, sTypeApi);
	} 
	
	@Test (groups = { "GetRubricatorWithoutAdvertType8_1" })
	@Parameters({"sBaseHost", "sParam", "sTypeApi"})
	public void Test43(String sBaseHost, String sParam, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRubricutorWithoutAdvertType8_1(sBaseHost, sParam, sTypeApi);
	} 
	
	@Test (groups = { "GetAdvertsFriendSocial8_2" })
	@Parameters({"sBaseHost", "sLogin", "sPassword" , "sParam", "sParam1", "bAuthFlag", "sTypeApi"})
	public void Test44(String sBaseHost, String sLogin, String sPassword, String sParam, String sParam1, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetAdvertsFriendSocial8_2(sBaseHost, sLogin, sPassword, sParam, sParam1, bAuthFlag, sTypeApi);
	} 
	
	@Test (groups = { "ComplaintToAdvert8_3" })
	@Parameters({"sBaseHost",  "sParam", "sParam1", "sIdAdvert", "sTypeApi"})
	public void Test45(String sBaseHost, String sParam, String sParam1, String sIdAdvert, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.ComplaintToAdvert8_3(sBaseHost, sParam, sParam1, sIdAdvert, sTypeApi);
	} 
	
	@Test (groups = { "GetRelatedAdverts8_4" })
	@Parameters({"sBaseHost", "sIdAdvert", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test46(String sBaseHost, String sIdAdvert, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRelatedAdverts8_4(sBaseHost, sIdAdvert, sLogin, sPassword, bAuthFlag, sTypeApi);
	} 
	
	@Test (groups = { "GetRegionByCoordinates8_5" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sTypeApi"})
	public void Test47(String sBaseHost, String sParam, String sParam1, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRegionByCoordinates8_5(sBaseHost, sParam, sParam1, sTypeApi);
	} 
	
	@Test (groups = { "GetRegionByIP8_6" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test48(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRegionByIP8_6(sBaseHost, sTypeApi);
	} 
	
	@Test (groups = { "GetRadiusList8_8" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test49(String sBaseHost, String sParam, String sParam1, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetRadiusList8_8(sBaseHost, sParam, sParam1, sLogin, sPassword, bAuthFlag, sTypeApi);
	}
	
	@Test (groups = { "GetListRelativeUser8_7" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test50(String sBaseHost, String sParam, String sParam1, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListRelativeUser8_7(sBaseHost, sParam, sParam1, sLogin, sPassword, bAuthFlag, sTypeApi);
	} 
	
	@Test (groups = { "GetLadderUp8_9" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sTypeApi"})
	public void Test51(String sBaseHost, String sParam, String sParam1, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetLadderUp8_9(sBaseHost, sParam, sParam1, sTypeApi);
	} 
	
	@Test (groups = { "GetMultiBlock9_1" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sTypeApi"})
	public void Test52(String sBaseHost, String sParam, String sParam1, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetMultiBlock9_1(sBaseHost, sParam, sParam1, sTypeApi);
	} 
	
	
	@Test (groups = { "GetListAdvertForSite9_2" })
	@Parameters({"sBaseHost", "sParam", "sParam1", "sLogin", "sPassword", "bAuthFlag", "sTypeApi"})
	public void Test53(String sBaseHost, String sParam, String sParam1, String sLogin, String sPassword, boolean bAuthFlag, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetListAdvertForSite9_2(sBaseHost, sParam, sParam1, sLogin, sPassword, bAuthFlag, sTypeApi);
	} 
	
	@Test (groups = { "GetHistoryView9_3" })
	@Parameters({"sBaseHost", "sIdAdvert", "sTypeApi"})
	public void Test54(String sBaseHost, String sIdAdvert, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException
	{
		cM.GetHistoryView9_3(sBaseHost, sIdAdvert, sTypeApi);
	} 
	
//////////////////////////////////////////////////////////////////////////////////////////////
	@Test (groups = { "Super_WorkProfile" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test_Super_WorkProfile(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, ClassNotFoundException
	{
		cM.Super_WorkProfile(sBaseHost, sTypeApi);
	} 
	
	@Test (groups = { "Super_WorkAdvert" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test_Super_WorkAdvert(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, ClassNotFoundException, NumberFormatException, InterruptedException
	{
		cM.Super_WorkAdvert(sBaseHost, sTypeApi);
	}
	
	@Test (groups = { "Super_WorkSearch" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test_Super_WorkSearch(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, ClassNotFoundException, NumberFormatException, InterruptedException
	{
		cM.Super_WorkSearch(sBaseHost, sTypeApi);
	} 
	
	@Test (groups = { "Super_WorkFavourite" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test_Super_WorkFavourite(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, ClassNotFoundException, NumberFormatException, InterruptedException
	{
		cM.Super_WorkFavourite(sBaseHost, sTypeApi);
	} 
	
	@Test (groups = { "Super_ChooseRegion" })
	@Parameters({"sBaseHost", "sTypeApi"})
	public void Test_Super_ChooseRegion(String sBaseHost, String sTypeApi) throws URISyntaxException, IOException, ExceptFailTest, JSONException, ClassNotFoundException, NumberFormatException, InterruptedException
	{
		cM.Super_ChooseRegion(sBaseHost, sTypeApi);
	} 
	
}