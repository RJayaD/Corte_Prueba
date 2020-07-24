package com.example.corteprueba;
import com.example.corteprueba.Models.*;
import com.example.corteprueba.Adaptadores.AdapterRecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.corteprueba.Services.Service;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;

    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        try {
            Clase();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void Clase() throws JSONException {
        String myJsonString= "{data:[{\"name\":\"Argentina\",\"topLevelDomain\":[\".ar\"],\"alpha2Code\":\"AR\",\"alpha3Code\":\"ARG\",\"callingCodes\":[\"54\"],\"capital\":\"Buenos Aires\",\"altSpellings\":[\"AR\",\"Argentine Republic\",\"República Argentina\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"latlng\":[-34.0,-64.0],\"demonym\":\"Argentinean\",\"area\":2780400.0,\"gini\":44.5,\"timezones\":[\"UTC-03:00\"],\"borders\":[\"BOL\",\"BRA\",\"CHL\",\"PRY\",\"URY\"],\"nativeName\":\"Argentina\",\"numericCode\":\"032\",\"currencies\":[{\"code\":\"ARS\",\"name\":\"Argentine peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"gn\",\"iso639_2\":\"grn\",\"name\":\"Guaraní\",\"nativeName\":\"Avañe'ẽ\"}],\"translations\":{\"de\":\"Argentinien\",\"es\":\"Argentina\",\"fr\":\"Argentine\",\"ja\":\"アルゼンチン\",\"it\":\"Argentina\",\"br\":\"Argentina\",\"pt\":\"Argentina\",\"nl\":\"Argentinië\",\"hr\":\"Argentina\",\"fa\":\"آرژانتین\"},\"flag\":\"https://restcountries.eu/data/arg.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"ARG\"},{\"name\":\"Belize\",\"topLevelDomain\":[\".bz\"],\"alpha2Code\":\"BZ\",\"alpha3Code\":\"BLZ\",\"callingCodes\":[\"501\"],\"capital\":\"Belmopan\",\"altSpellings\":[\"BZ\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":370300,\"latlng\":[17.25,-88.75],\"demonym\":\"Belizean\",\"area\":22966.0,\"gini\":53.1,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"GTM\",\"MEX\"],\"nativeName\":\"Belize\",\"numericCode\":\"084\",\"currencies\":[{\"code\":\"BZD\",\"name\":\"Belize dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"},{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Belize\",\"es\":\"Belice\",\"fr\":\"Belize\",\"ja\":\"ベリーズ\",\"it\":\"Belize\",\"br\":\"Belize\",\"pt\":\"Belize\",\"nl\":\"Belize\",\"hr\":\"Belize\",\"fa\":\"بلیز\"},\"flag\":\"https://restcountries.eu/data/blz.svg\",\"regionalBlocs\":[{\"acronym\":\"CARICOM\",\"name\":\"Caribbean Community\",\"otherAcronyms\":[],\"otherNames\":[\"Comunidad del Caribe\",\"Communauté Caribéenne\",\"Caribische Gemeenschap\"]},{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"BIZ\"},{\"name\":\"Bolivia (Plurinational State of)\",\"topLevelDomain\":[\".bo\"],\"alpha2Code\":\"BO\",\"alpha3Code\":\"BOL\",\"callingCodes\":[\"591\"],\"capital\":\"Sucre\",\"altSpellings\":[\"BO\",\"Buliwya\",\"Wuliwya\",\"Plurinational State of Bolivia\",\"Estado Plurinacional de Bolivia\",\"Buliwya Mamallaqta\",\"Wuliwya Suyu\",\"Tetã Volívia\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"latlng\":[-17.0,-65.0],\"demonym\":\"Bolivian\",\"area\":1098581.0,\"gini\":56.3,\"timezones\":[\"UTC-04:00\"],\"borders\":[\"ARG\",\"BRA\",\"CHL\",\"PRY\",\"PER\"],\"nativeName\":\"Bolivia\",\"numericCode\":\"068\",\"currencies\":[{\"code\":\"BOB\",\"name\":\"Bolivian boliviano\",\"symbol\":\"Bs.\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"ay\",\"iso639_2\":\"aym\",\"name\":\"Aymara\",\"nativeName\":\"aymar aru\"},{\"iso639_1\":\"qu\",\"iso639_2\":\"que\",\"name\":\"Quechua\",\"nativeName\":\"Runa Simi\"}],\"translations\":{\"de\":\"Bolivien\",\"es\":\"Bolivia\",\"fr\":\"Bolivie\",\"ja\":\"ボリビア多民族国\",\"it\":\"Bolivia\",\"br\":\"Bolívia\",\"pt\":\"Bolívia\",\"nl\":\"Bolivia\",\"hr\":\"Bolivija\",\"fa\":\"بولیوی\"},\"flag\":\"https://restcountries.eu/data/bol.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"BOL\"},{\"name\":\"Chile\",\"topLevelDomain\":[\".cl\"],\"alpha2Code\":\"CL\",\"alpha3Code\":\"CHL\",\"callingCodes\":[\"56\"],\"capital\":\"Santiago\",\"altSpellings\":[\"CL\",\"Republic of Chile\",\"República de Chile\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"latlng\":[-30.0,-71.0],\"demonym\":\"Chilean\",\"area\":756102.0,\"gini\":52.1,\"timezones\":[\"UTC-06:00\",\"UTC-04:00\"],\"borders\":[\"ARG\",\"BOL\",\"PER\"],\"nativeName\":\"Chile\",\"numericCode\":\"152\",\"currencies\":[{\"code\":\"CLP\",\"name\":\"Chilean peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Chile\",\"es\":\"Chile\",\"fr\":\"Chili\",\"ja\":\"チリ\",\"it\":\"Cile\",\"br\":\"Chile\",\"pt\":\"Chile\",\"nl\":\"Chili\",\"hr\":\"Čile\",\"fa\":\"شیلی\"},\"flag\":\"https://restcountries.eu/data/chl.svg\",\"regionalBlocs\":[{\"acronym\":\"PA\",\"name\":\"Pacific Alliance\",\"otherAcronyms\":[],\"otherNames\":[\"Alianza del Pacífico\"]},{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"CHI\"},{\"name\":\"Colombia\",\"topLevelDomain\":[\".co\"],\"alpha2Code\":\"CO\",\"alpha3Code\":\"COL\",\"callingCodes\":[\"57\"],\"capital\":\"Bogotá\",\"altSpellings\":[\"CO\",\"Republic of Colombia\",\"República de Colombia\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"latlng\":[4.0,-72.0],\"demonym\":\"Colombian\",\"area\":1141748.0,\"gini\":55.9,\"timezones\":[\"UTC-05:00\"],\"borders\":[\"BRA\",\"ECU\",\"PAN\",\"PER\",\"VEN\"],\"nativeName\":\"Colombia\",\"numericCode\":\"170\",\"currencies\":[{\"code\":\"COP\",\"name\":\"Colombian peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Kolumbien\",\"es\":\"Colombia\",\"fr\":\"Colombie\",\"ja\":\"コロンビア\",\"it\":\"Colombia\",\"br\":\"Colômbia\",\"pt\":\"Colômbia\",\"nl\":\"Colombia\",\"hr\":\"Kolumbija\",\"fa\":\"کلمبیا\"},\"flag\":\"https://restcountries.eu/data/col.svg\",\"regionalBlocs\":[{\"acronym\":\"PA\",\"name\":\"Pacific Alliance\",\"otherAcronyms\":[],\"otherNames\":[\"Alianza del Pacífico\"]},{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"COL\"},{\"name\":\"Costa Rica\",\"topLevelDomain\":[\".cr\"],\"alpha2Code\":\"CR\",\"alpha3Code\":\"CRI\",\"callingCodes\":[\"506\"],\"capital\":\"San José\",\"altSpellings\":[\"CR\",\"Republic of Costa Rica\",\"República de Costa Rica\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":4890379,\"latlng\":[10.0,-84.0],\"demonym\":\"Costa Rican\",\"area\":51100.0,\"gini\":50.7,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"NIC\",\"PAN\"],\"nativeName\":\"Costa Rica\",\"numericCode\":\"188\",\"currencies\":[{\"code\":\"CRC\",\"name\":\"Costa Rican colón\",\"symbol\":\"₡\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Costa Rica\",\"es\":\"Costa Rica\",\"fr\":\"Costa Rica\",\"ja\":\"コスタリカ\",\"it\":\"Costa Rica\",\"br\":\"Costa Rica\",\"pt\":\"Costa Rica\",\"nl\":\"Costa Rica\",\"hr\":\"Kostarika\",\"fa\":\"کاستاریکا\"},\"flag\":\"https://restcountries.eu/data/cri.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"CRC\"},{\"name\":\"Cuba\",\"topLevelDomain\":[\".cu\"],\"alpha2Code\":\"CU\",\"alpha3Code\":\"CUB\",\"callingCodes\":[\"53\"],\"capital\":\"Havana\",\"altSpellings\":[\"CU\",\"Republic of Cuba\",\"República de Cuba\"],\"region\":\"Americas\",\"subregion\":\"Caribbean\",\"population\":11239004,\"latlng\":[21.5,-80.0],\"demonym\":\"Cuban\",\"area\":109884.0,\"gini\":null,\"timezones\":[\"UTC-05:00\"],\"borders\":[],\"nativeName\":\"Cuba\",\"numericCode\":\"192\",\"currencies\":[{\"code\":\"CUC\",\"name\":\"Cuban convertible peso\",\"symbol\":\"$\"},{\"code\":\"CUP\",\"name\":\"Cuban peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Kuba\",\"es\":\"Cuba\",\"fr\":\"Cuba\",\"ja\":\"キューバ\",\"it\":\"Cuba\",\"br\":\"Cuba\",\"pt\":\"Cuba\",\"nl\":\"Cuba\",\"hr\":\"Kuba\",\"fa\":\"کوبا\"},\"flag\":\"https://restcountries.eu/data/cub.svg\",\"regionalBlocs\":[],\"cioc\":\"CUB\"},{\"name\":\"Dominican Republic\",\"topLevelDomain\":[\".do\"],\"alpha2Code\":\"DO\",\"alpha3Code\":\"DOM\",\"callingCodes\":[\"1809\",\"1829\",\"1849\"],\"capital\":\"Santo Domingo\",\"altSpellings\":[\"DO\"],\"region\":\"Americas\",\"subregion\":\"Caribbean\",\"population\":10075045,\"latlng\":[19.0,-70.66666666],\"demonym\":\"Dominican\",\"area\":48671.0,\"gini\":47.2,\"timezones\":[\"UTC-04:00\"],\"borders\":[\"HTI\"],\"nativeName\":\"República Dominicana\",\"numericCode\":\"214\",\"currencies\":[{\"code\":\"DOP\",\"name\":\"Dominican peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Dominikanische Republik\",\"es\":\"República Dominicana\",\"fr\":\"République dominicaine\",\"ja\":\"ドミニカ共和国\",\"it\":\"Repubblica Dominicana\",\"br\":\"República Dominicana\",\"pt\":\"República Dominicana\",\"nl\":\"Dominicaanse Republiek\",\"hr\":\"Dominikanska Republika\",\"fa\":\"جمهوری دومینیکن\"},\"flag\":\"https://restcountries.eu/data/dom.svg\",\"regionalBlocs\":[{\"acronym\":\"CARICOM\",\"name\":\"Caribbean Community\",\"otherAcronyms\":[],\"otherNames\":[\"Comunidad del Caribe\",\"Communauté Caribéenne\",\"Caribische Gemeenschap\"]},{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"DOM\"},{\"name\":\"Ecuador\",\"topLevelDomain\":[\".ec\"],\"alpha2Code\":\"EC\",\"alpha3Code\":\"ECU\",\"callingCodes\":[\"593\"],\"capital\":\"Quito\",\"altSpellings\":[\"EC\",\"Republic of Ecuador\",\"República del Ecuador\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":16545799,\"latlng\":[-2.0,-77.5],\"demonym\":\"Ecuadorean\",\"area\":276841.0,\"gini\":49.3,\"timezones\":[\"UTC-06:00\",\"UTC-05:00\"],\"borders\":[\"COL\",\"PER\"],\"nativeName\":\"Ecuador\",\"numericCode\":\"218\",\"currencies\":[{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Ecuador\",\"es\":\"Ecuador\",\"fr\":\"Équateur\",\"ja\":\"エクアドル\",\"it\":\"Ecuador\",\"br\":\"Equador\",\"pt\":\"Equador\",\"nl\":\"Ecuador\",\"hr\":\"Ekvador\",\"fa\":\"اکوادور\"},\"flag\":\"https://restcountries.eu/data/ecu.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"ECU\"},{\"name\":\"El Salvador\",\"topLevelDomain\":[\".sv\"],\"alpha2Code\":\"SV\",\"alpha3Code\":\"SLV\",\"callingCodes\":[\"503\"],\"capital\":\"San Salvador\",\"altSpellings\":[\"SV\",\"Republic of El Salvador\",\"República de El Salvador\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":6520675,\"latlng\":[13.83333333,-88.91666666],\"demonym\":\"Salvadoran\",\"area\":21041.0,\"gini\":48.3,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"GTM\",\"HND\"],\"nativeName\":\"El Salvador\",\"numericCode\":\"222\",\"currencies\":[{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"El Salvador\",\"es\":\"El Salvador\",\"fr\":\"Salvador\",\"ja\":\"エルサルバドル\",\"it\":\"El Salvador\",\"br\":\"El Salvador\",\"pt\":\"El Salvador\",\"nl\":\"El Salvador\",\"hr\":\"Salvador\",\"fa\":\"السالوادور\"},\"flag\":\"https://restcountries.eu/data/slv.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"ESA\"},{\"name\":\"Equatorial Guinea\",\"topLevelDomain\":[\".gq\"],\"alpha2Code\":\"GQ\",\"alpha3Code\":\"GNQ\",\"callingCodes\":[\"240\"],\"capital\":\"Malabo\",\"altSpellings\":[\"GQ\",\"Republic of Equatorial Guinea\",\"República de Guinea Ecuatorial\",\"République de Guinée équatoriale\",\"República da Guiné Equatorial\"],\"region\":\"Africa\",\"subregion\":\"Middle Africa\",\"population\":1222442,\"latlng\":[2.0,10.0],\"demonym\":\"Equatorial Guinean\",\"area\":28051.0,\"gini\":null,\"timezones\":[\"UTC+01:00\"],\"borders\":[\"CMR\",\"GAB\"],\"nativeName\":\"Guinea Ecuatorial\",\"numericCode\":\"226\",\"currencies\":[{\"code\":\"XAF\",\"name\":\"Central African CFA franc\",\"symbol\":\"Fr\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"fr\",\"iso639_2\":\"fra\",\"name\":\"French\",\"nativeName\":\"français\"}],\"translations\":{\"de\":\"Äquatorial-Guinea\",\"es\":\"Guinea Ecuatorial\",\"fr\":\"Guinée-Équatoriale\",\"ja\":\"赤道ギニア\",\"it\":\"Guinea Equatoriale\",\"br\":\"Guiné Equatorial\",\"pt\":\"Guiné Equatorial\",\"nl\":\"Equatoriaal-Guinea\",\"hr\":\"Ekvatorijalna Gvineja\",\"fa\":\"گینه استوایی\"},\"flag\":\"https://restcountries.eu/data/gnq.svg\",\"regionalBlocs\":[{\"acronym\":\"AU\",\"name\":\"African Union\",\"otherAcronyms\":[],\"otherNames\":[\"الاتحاد الأفريقي\",\"Union africaine\",\"União Africana\",\"Unión Africana\",\"Umoja wa Afrika\"]}],\"cioc\":\"GEQ\"},{\"name\":\"Guam\",\"topLevelDomain\":[\".gu\"],\"alpha2Code\":\"GU\",\"alpha3Code\":\"GUM\",\"callingCodes\":[\"1671\"],\"capital\":\"Hagåtña\",\"altSpellings\":[\"GU\",\"Guåhån\"],\"region\":\"Oceania\",\"subregion\":\"Micronesia\",\"population\":184200,\"latlng\":[13.46666666,144.78333333],\"demonym\":\"Guamanian\",\"area\":549.0,\"gini\":null,\"timezones\":[\"UTC+10:00\"],\"borders\":[],\"nativeName\":\"Guam\",\"numericCode\":\"316\",\"currencies\":[{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"},{\"iso639_1\":\"ch\",\"iso639_2\":\"cha\",\"name\":\"Chamorro\",\"nativeName\":\"Chamoru\"},{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Guam\",\"es\":\"Guam\",\"fr\":\"Guam\",\"ja\":\"グアム\",\"it\":\"Guam\",\"br\":\"Guam\",\"pt\":\"Guame\",\"nl\":\"Guam\",\"hr\":\"Guam\",\"fa\":\"گوام\"},\"flag\":\"https://restcountries.eu/data/gum.svg\",\"regionalBlocs\":[],\"cioc\":\"GUM\"},{\"name\":\"Guatemala\",\"topLevelDomain\":[\".gt\"],\"alpha2Code\":\"GT\",\"alpha3Code\":\"GTM\",\"callingCodes\":[\"502\"],\"capital\":\"Guatemala City\",\"altSpellings\":[\"GT\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":16176133,\"latlng\":[15.5,-90.25],\"demonym\":\"Guatemalan\",\"area\":108889.0,\"gini\":55.9,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"BLZ\",\"SLV\",\"HND\",\"MEX\"],\"nativeName\":\"Guatemala\",\"numericCode\":\"320\",\"currencies\":[{\"code\":\"GTQ\",\"name\":\"Guatemalan quetzal\",\"symbol\":\"Q\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Guatemala\",\"es\":\"Guatemala\",\"fr\":\"Guatemala\",\"ja\":\"グアテマラ\",\"it\":\"Guatemala\",\"br\":\"Guatemala\",\"pt\":\"Guatemala\",\"nl\":\"Guatemala\",\"hr\":\"Gvatemala\",\"fa\":\"گواتمالا\"},\"flag\":\"https://restcountries.eu/data/gtm.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"GUA\"},{\"name\":\"Honduras\",\"topLevelDomain\":[\".hn\"],\"alpha2Code\":\"HN\",\"alpha3Code\":\"HND\",\"callingCodes\":[\"504\"],\"capital\":\"Tegucigalpa\",\"altSpellings\":[\"HN\",\"Republic of Honduras\",\"República de Honduras\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":8576532,\"latlng\":[15.0,-86.5],\"demonym\":\"Honduran\",\"area\":112492.0,\"gini\":57.0,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"GTM\",\"SLV\",\"NIC\"],\"nativeName\":\"Honduras\",\"numericCode\":\"340\",\"currencies\":[{\"code\":\"HNL\",\"name\":\"Honduran lempira\",\"symbol\":\"L\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Honduras\",\"es\":\"Honduras\",\"fr\":\"Honduras\",\"ja\":\"ホンジュラス\",\"it\":\"Honduras\",\"br\":\"Honduras\",\"pt\":\"Honduras\",\"nl\":\"Honduras\",\"hr\":\"Honduras\",\"fa\":\"هندوراس\"},\"flag\":\"https://restcountries.eu/data/hnd.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"HON\"},{\"name\":\"Mexico\",\"topLevelDomain\":[\".mx\"],\"alpha2Code\":\"MX\",\"alpha3Code\":\"MEX\",\"callingCodes\":[\"52\"],\"capital\":\"Mexico City\",\"altSpellings\":[\"MX\",\"Mexicanos\",\"United Mexican States\",\"Estados Unidos Mexicanos\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":122273473,\"latlng\":[23.0,-102.0],\"demonym\":\"Mexican\",\"area\":1964375.0,\"gini\":47.0,\"timezones\":[\"UTC-08:00\",\"UTC-07:00\",\"UTC-06:00\"],\"borders\":[\"BLZ\",\"GTM\",\"USA\"],\"nativeName\":\"México\",\"numericCode\":\"484\",\"currencies\":[{\"code\":\"MXN\",\"name\":\"Mexican peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Mexiko\",\"es\":\"México\",\"fr\":\"Mexique\",\"ja\":\"メキシコ\",\"it\":\"Messico\",\"br\":\"México\",\"pt\":\"México\",\"nl\":\"Mexico\",\"hr\":\"Meksiko\",\"fa\":\"مکزیک\"},\"flag\":\"https://restcountries.eu/data/mex.svg\",\"regionalBlocs\":[{\"acronym\":\"PA\",\"name\":\"Pacific Alliance\",\"otherAcronyms\":[],\"otherNames\":[\"Alianza del Pacífico\"]},{\"acronym\":\"NAFTA\",\"name\":\"North American Free Trade Agreement\",\"otherAcronyms\":[],\"otherNames\":[\"Tratado de Libre Comercio de América del Norte\",\"Accord de Libre-échange Nord-Américain\"]}],\"cioc\":\"MEX\"},{\"name\":\"Nicaragua\",\"topLevelDomain\":[\".ni\"],\"alpha2Code\":\"NI\",\"alpha3Code\":\"NIC\",\"callingCodes\":[\"505\"],\"capital\":\"Managua\",\"altSpellings\":[\"NI\",\"Republic of Nicaragua\",\"República de Nicaragua\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":6262703,\"latlng\":[13.0,-85.0],\"demonym\":\"Nicaraguan\",\"area\":130373.0,\"gini\":40.5,\"timezones\":[\"UTC-06:00\"],\"borders\":[\"CRI\",\"HND\"],\"nativeName\":\"Nicaragua\",\"numericCode\":\"558\",\"currencies\":[{\"code\":\"NIO\",\"name\":\"Nicaraguan córdoba\",\"symbol\":\"C$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Nicaragua\",\"es\":\"Nicaragua\",\"fr\":\"Nicaragua\",\"ja\":\"ニカラグア\",\"it\":\"Nicaragua\",\"br\":\"Nicarágua\",\"pt\":\"Nicarágua\",\"nl\":\"Nicaragua\",\"hr\":\"Nikaragva\",\"fa\":\"نیکاراگوئه\"},\"flag\":\"https://restcountries.eu/data/nic.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"NCA\"},{\"name\":\"Panama\",\"topLevelDomain\":[\".pa\"],\"alpha2Code\":\"PA\",\"alpha3Code\":\"PAN\",\"callingCodes\":[\"507\"],\"capital\":\"Panama City\",\"altSpellings\":[\"PA\",\"Republic of Panama\",\"República de Panamá\"],\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":3814672,\"latlng\":[9.0,-80.0],\"demonym\":\"Panamanian\",\"area\":75417.0,\"gini\":51.9,\"timezones\":[\"UTC-05:00\"],\"borders\":[\"COL\",\"CRI\"],\"nativeName\":\"Panamá\",\"numericCode\":\"591\",\"currencies\":[{\"code\":\"PAB\",\"name\":\"Panamanian balboa\",\"symbol\":\"B/.\"},{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Panama\",\"es\":\"Panamá\",\"fr\":\"Panama\",\"ja\":\"パナマ\",\"it\":\"Panama\",\"br\":\"Panamá\",\"pt\":\"Panamá\",\"nl\":\"Panama\",\"hr\":\"Panama\",\"fa\":\"پاناما\"},\"flag\":\"https://restcountries.eu/data/pan.svg\",\"regionalBlocs\":[{\"acronym\":\"CAIS\",\"name\":\"Central American Integration System\",\"otherAcronyms\":[\"SICA\"],\"otherNames\":[\"Sistema de la Integración Centroamericana,\"]}],\"cioc\":\"PAN\"},{\"name\":\"Paraguay\",\"topLevelDomain\":[\".py\"],\"alpha2Code\":\"PY\",\"alpha3Code\":\"PRY\",\"callingCodes\":[\"595\"],\"capital\":\"Asunción\",\"altSpellings\":[\"PY\",\"Republic of Paraguay\",\"República del Paraguay\",\"Tetã Paraguái\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"latlng\":[-23.0,-58.0],\"demonym\":\"Paraguayan\",\"area\":406752.0,\"gini\":52.4,\"timezones\":[\"UTC-04:00\"],\"borders\":[\"ARG\",\"BOL\",\"BRA\"],\"nativeName\":\"Paraguay\",\"numericCode\":\"600\",\"currencies\":[{\"code\":\"PYG\",\"name\":\"Paraguayan guaraní\",\"symbol\":\"₲\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"gn\",\"iso639_2\":\"grn\",\"name\":\"Guaraní\",\"nativeName\":\"Avañe'ẽ\"}],\"translations\":{\"de\":\"Paraguay\",\"es\":\"Paraguay\",\"fr\":\"Paraguay\",\"ja\":\"パラグアイ\",\"it\":\"Paraguay\",\"br\":\"Paraguai\",\"pt\":\"Paraguai\",\"nl\":\"Paraguay\",\"hr\":\"Paragvaj\",\"fa\":\"پاراگوئه\"},\"flag\":\"https://restcountries.eu/data/pry.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"PAR\"},{\"name\":\"Peru\",\"topLevelDomain\":[\".pe\"],\"alpha2Code\":\"PE\",\"alpha3Code\":\"PER\",\"callingCodes\":[\"51\"],\"capital\":\"Lima\",\"altSpellings\":[\"PE\",\"Republic of Peru\",\" República del Perú\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"latlng\":[-10.0,-76.0],\"demonym\":\"Peruvian\",\"area\":1285216.0,\"gini\":48.1,\"timezones\":[\"UTC-05:00\"],\"borders\":[\"BOL\",\"BRA\",\"CHL\",\"COL\",\"ECU\"],\"nativeName\":\"Perú\",\"numericCode\":\"604\",\"currencies\":[{\"code\":\"PEN\",\"name\":\"Peruvian sol\",\"symbol\":\"S/.\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Peru\",\"es\":\"Perú\",\"fr\":\"Pérou\",\"ja\":\"ペルー\",\"it\":\"Perù\",\"br\":\"Peru\",\"pt\":\"Peru\",\"nl\":\"Peru\",\"hr\":\"Peru\",\"fa\":\"پرو\"},\"flag\":\"https://restcountries.eu/data/per.svg\",\"regionalBlocs\":[{\"acronym\":\"PA\",\"name\":\"Pacific Alliance\",\"otherAcronyms\":[],\"otherNames\":[\"Alianza del Pacífico\"]},{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"PER\"},{\"name\":\"Puerto Rico\",\"topLevelDomain\":[\".pr\"],\"alpha2Code\":\"PR\",\"alpha3Code\":\"PRI\",\"callingCodes\":[\"1787\",\"1939\"],\"capital\":\"San Juan\",\"altSpellings\":[\"PR\",\"Commonwealth of Puerto Rico\",\"Estado Libre Asociado de Puerto Rico\"],\"region\":\"Americas\",\"subregion\":\"Caribbean\",\"population\":3474182,\"latlng\":[18.25,-66.5],\"demonym\":\"Puerto Rican\",\"area\":8870.0,\"gini\":null,\"timezones\":[\"UTC-04:00\"],\"borders\":[],\"nativeName\":\"Puerto Rico\",\"numericCode\":\"630\",\"currencies\":[{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"}],\"translations\":{\"de\":\"Puerto Rico\",\"es\":\"Puerto Rico\",\"fr\":\"Porto Rico\",\"ja\":\"プエルトリコ\",\"it\":\"Porto Rico\",\"br\":\"Porto Rico\",\"pt\":\"Porto Rico\",\"nl\":\"Puerto Rico\",\"hr\":\"Portoriko\",\"fa\":\"پورتو ریکو\"},\"flag\":\"https://restcountries.eu/data/pri.svg\",\"regionalBlocs\":[],\"cioc\":\"PUR\"},{\"name\":\"Spain\",\"topLevelDomain\":[\".es\"],\"alpha2Code\":\"ES\",\"alpha3Code\":\"ESP\",\"callingCodes\":[\"34\"],\"capital\":\"Madrid\",\"altSpellings\":[\"ES\",\"Kingdom of Spain\",\"Reino de España\"],\"region\":\"Europe\",\"subregion\":\"Southern Europe\",\"population\":46438422,\"latlng\":[40.0,-4.0],\"demonym\":\"Spanish\",\"area\":505992.0,\"gini\":34.7,\"timezones\":[\"UTC\",\"UTC+01:00\"],\"borders\":[\"AND\",\"FRA\",\"GIB\",\"PRT\",\"MAR\"],\"nativeName\":\"España\",\"numericCode\":\"724\",\"currencies\":[{\"code\":\"EUR\",\"name\":\"Euro\",\"symbol\":\"€\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Spanien\",\"es\":\"España\",\"fr\":\"Espagne\",\"ja\":\"スペイン\",\"it\":\"Spagna\",\"br\":\"Espanha\",\"pt\":\"Espanha\",\"nl\":\"Spanje\",\"hr\":\"Španjolska\",\"fa\":\"اسپانیا\"},\"flag\":\"https://restcountries.eu/data/esp.svg\",\"regionalBlocs\":[{\"acronym\":\"EU\",\"name\":\"European Union\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"ESP\"},{\"name\":\"Uruguay\",\"topLevelDomain\":[\".uy\"],\"alpha2Code\":\"UY\",\"alpha3Code\":\"URY\",\"callingCodes\":[\"598\"],\"capital\":\"Montevideo\",\"altSpellings\":[\"UY\",\"Oriental Republic of Uruguay\",\"República Oriental del Uruguay\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":3480222,\"latlng\":[-33.0,-56.0],\"demonym\":\"Uruguayan\",\"area\":181034.0,\"gini\":39.7,\"timezones\":[\"UTC-03:00\"],\"borders\":[\"ARG\",\"BRA\"],\"nativeName\":\"Uruguay\",\"numericCode\":\"858\",\"currencies\":[{\"code\":\"UYU\",\"name\":\"Uruguayan peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Uruguay\",\"es\":\"Uruguay\",\"fr\":\"Uruguay\",\"ja\":\"ウルグアイ\",\"it\":\"Uruguay\",\"br\":\"Uruguai\",\"pt\":\"Uruguai\",\"nl\":\"Uruguay\",\"hr\":\"Urugvaj\",\"fa\":\"اروگوئه\"},\"flag\":\"https://restcountries.eu/data/ury.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"URU\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"topLevelDomain\":[\".ve\"],\"alpha2Code\":\"VE\",\"alpha3Code\":\"VEN\",\"callingCodes\":[\"58\"],\"capital\":\"Caracas\",\"altSpellings\":[\"VE\",\"Bolivarian Republic of Venezuela\",\"República Bolivariana de Venezuela\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"latlng\":[8.0,-66.0],\"demonym\":\"Venezuelan\",\"area\":916445.0,\"gini\":44.8,\"timezones\":[\"UTC-04:00\"],\"borders\":[\"BRA\",\"COL\",\"GUY\"],\"nativeName\":\"Venezuela\",\"numericCode\":\"862\",\"currencies\":[{\"code\":\"VEF\",\"name\":\"Venezuelan bolívar\",\"symbol\":\"Bs F\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Venezuela\",\"es\":\"Venezuela\",\"fr\":\"Venezuela\",\"ja\":\"ベネズエラ・ボリバル共和国\",\"it\":\"Venezuela\",\"br\":\"Venezuela\",\"pt\":\"Venezuela\",\"nl\":\"Venezuela\",\"hr\":\"Venezuela\",\"fa\":\"ونزوئلا\"},\"flag\":\"https://restcountries.eu/data/ven.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"VEN\"},{\"name\":\"Western Sahara\",\"topLevelDomain\":[\".eh\"],\"alpha2Code\":\"EH\",\"alpha3Code\":\"ESH\",\"callingCodes\":[\"212\"],\"capital\":\"El Aaiún\",\"altSpellings\":[\"EH\",\"Taneẓroft Tutrimt\"],\"region\":\"Africa\",\"subregion\":\"Northern Africa\",\"population\":510713,\"latlng\":[24.5,-13.0],\"demonym\":\"Sahrawi\",\"area\":266000.0,\"gini\":null,\"timezones\":[\"UTC+00:00\"],\"borders\":[\"DZA\",\"MRT\",\"MAR\"],\"nativeName\":\"الصحراء الغربية\",\"numericCode\":\"732\",\"currencies\":[{\"code\":\"MAD\",\"name\":\"Moroccan dirham\",\"symbol\":\"د.م.\"},{\"code\":\"DZD\",\"name\":\"Algerian dinar\",\"symbol\":\"د.ج\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"}],\"translations\":{\"de\":\"Westsahara\",\"es\":\"Sahara Occidental\",\"fr\":\"Sahara Occidental\",\"ja\":\"西サハラ\",\"it\":\"Sahara Occidentale\",\"br\":\"Saara Ocidental\",\"pt\":\"Saara Ocidental\",\"nl\":\"Westelijke Sahara\",\"hr\":\"Zapadna Sahara\",\"fa\":\"جمهوری دموکراتیک عربی صحرا\"},\"flag\":\"https://restcountries.eu/data/esh.svg\",\"regionalBlocs\":[{\"acronym\":\"AU\",\"name\":\"African Union\",\"otherAcronyms\":[],\"otherNames\":[\"الاتحاد الأفريقي\",\"Union africaine\",\"União Africana\",\"Unión Africana\",\"Umoja wa Afrika\"]}],\"cioc\":\"\"}]}";
        JSONObject JSONlista =  new JSONObject();
        JSONlista = new JSONObject(myJsonString);
        JSONArray JSONArray=  JSONlista.getJSONArray("data");
        ArrayList<Datum> data = Datum.JsonObjectsBuild(JSONArray);
        recyclerView=(RecyclerView)findViewById(R.id.Rec_Data);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        adapterRecycler= new AdapterRecycler(data);
        recyclerView.setAdapter(adapterRecycler);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }





   /* public void Retro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<List<Datum>> reqData = service.getDatos();
        reqData.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                if (!response.isSuccessful()) {
                    Log.i("TAG", "Error" + response.code());
                } else {
                    Log.i("TAG", "Error1" );
                    List<Datum> Datab = response.body();
                    Log.i("TAG", "Error" + Datab.size());
                    adapterRecycler= new AdapterRecycler(Datab,this);
                    Log.i("TAG", "Error");
                    recyclerView.setAdapter(adapterRecycler);
                    Log.i("TAG", "Erroru");
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                Log.e("TAG", "Error: " + t.getMessage());
            }
        });
    }
*/


}