package com.country.tour.config;

import com.country.tour.model.entity.CountryEntity;
import com.country.tour.model.repository.CountryRepository;
import com.country.tour.model.entity.RateEntity;
import com.country.tour.model.repository.RateRepository;
import com.country.tour.model.entity.User;
import com.country.tour.model.repository.UserRepository;
import java.io.IOException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeanConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("*")
//						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
//						.allowedHeaders("Authorization");
//			}
//		};
//	}

  @Bean
  CommandLineRunner runner(CountryRepository countryRepository, RateRepository rateRepository,
      UserRepository userRepository)
      throws IOException {

    return args -> {

      userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN", true));

      ///////////////////////////////
      rateRepository.save(new RateEntity("AED", 4.310791));
      rateRepository.save(new RateEntity("AFN", 90.311162));
      rateRepository.save(new RateEntity("ALL", 123.113381));
      rateRepository.save(new RateEntity("AMD", 576.242194));
      rateRepository.save(new RateEntity("ANG", 2.106928));
      rateRepository.save(new RateEntity("AOA", 755.97184));
      rateRepository.save(new RateEntity("ARS", 90.85255));
      rateRepository.save(new RateEntity("AUD", 1.639382));
      rateRepository.save(new RateEntity("AWG", 2.11254));
      rateRepository.save(new RateEntity("AZN", 1.992496));
      rateRepository.save(new RateEntity("BAM", 1.946985));
      rateRepository.save(new RateEntity("BBD", 2.369933));
      rateRepository.save(new RateEntity("BDT", 99.528739));
      rateRepository.save(new RateEntity("BGN", 1.952835));
      rateRepository.save(new RateEntity("BHD", 0.44259));
      rateRepository.save(new RateEntity("BIF", 2268.046077));
      rateRepository.save(new RateEntity("BMD", 1.173633));
      rateRepository.save(new RateEntity("BND", 1.593859));
      rateRepository.save(new RateEntity("BOB", 8.110653));
      rateRepository.save(new RateEntity("BRL", 6.541711));
      rateRepository.save(new RateEntity("BSD", 1.173768));
      rateRepository.save(new RateEntity("BTC", 1.03E-4));
      rateRepository.save(new RateEntity("BTN", 86.060625));
      rateRepository.save(new RateEntity("BWP", 13.437453));
      rateRepository.save(new RateEntity("BYN", 3.016098));
      rateRepository.save(new RateEntity("BYR", 23003.209887));
      rateRepository.save(new RateEntity("BZD", 2.365951));
      rateRepository.save(new RateEntity("CAD", 1.541186));
      rateRepository.save(new RateEntity("CDF", 2297.63442));
      rateRepository.save(new RateEntity("CHF", 1.073522));
      rateRepository.save(new RateEntity("CLF", 0.033929));
      rateRepository.save(new RateEntity("CLP", 936.103306));
      rateRepository.save(new RateEntity("CNY", 7.918034));
      rateRepository.save(new RateEntity("COP", 4524.144568));
      rateRepository.save(new RateEntity("CRC", 707.525694));
      rateRepository.save(new RateEntity("CUC", 1.173633));
      rateRepository.save(new RateEntity("CUP", 31.101279));
      rateRepository.save(new RateEntity("CVE", 109.881362));
      rateRepository.save(new RateEntity("CZK", 27.376401));
      rateRepository.save(new RateEntity("DJF", 208.960687));
      rateRepository.save(new RateEntity("DKK", 7.443088));
      rateRepository.save(new RateEntity("DOP", 68.663431));
      rateRepository.save(new RateEntity("DZD", 151.463445));
      rateRepository.save(new RateEntity("EGP", 18.413832));
      rateRepository.save(new RateEntity("ERN", 17.604348));
      rateRepository.save(new RateEntity("ETB", 43.365635));
      rateRepository.save(new RateEntity("EUR", 1.0));
      rateRepository.save(new RateEntity("FJD", 2.511701));
      rateRepository.save(new RateEntity("FKP", 0.905855));
      rateRepository.save(new RateEntity("GBP", 0.905828));
      rateRepository.save(new RateEntity("GEL", 3.761505));
      rateRepository.save(new RateEntity("GGP", 0.905855));
      rateRepository.save(new RateEntity("GHS", 6.836461));
      rateRepository.save(new RateEntity("GIP", 0.905855));
      rateRepository.save(new RateEntity("GMD", 60.74726));
      rateRepository.save(new RateEntity("GNF", 11460.527516));
      rateRepository.save(new RateEntity("GTQ", 9.131814));
      rateRepository.save(new RateEntity("GYD", 245.564395));
      rateRepository.save(new RateEntity("HKD", 9.095704));
      rateRepository.save(new RateEntity("HNL", 28.865527));
      rateRepository.save(new RateEntity("HRK", 7.581083));
      rateRepository.save(new RateEntity("HTG", 73.947057));
      rateRepository.save(new RateEntity("HUF", 361.796478));
      rateRepository.save(new RateEntity("IDR", 17347.823791));
      rateRepository.save(new RateEntity("ILS", 3.977584));
      rateRepository.save(new RateEntity("IMP", 0.905855));
      rateRepository.save(new RateEntity("INR", 86.175951));
      rateRepository.save(new RateEntity("IQD", 1396.623457));
      rateRepository.save(new RateEntity("IRR", 49415.824189));
      rateRepository.save(new RateEntity("ISK", 162.993897));
      rateRepository.save(new RateEntity("JEP", 0.905855));
      rateRepository.save(new RateEntity("JMD", 169.608465));
      rateRepository.save(new RateEntity("JOD", 0.832102));
      rateRepository.save(new RateEntity("JPY", 123.893995));
      rateRepository.save(new RateEntity("KES", 127.526822));
      rateRepository.save(new RateEntity("KGS", 93.489153));
      rateRepository.save(new RateEntity("KHR", 4814.832675));
      rateRepository.save(new RateEntity("KMF", 488.816114));
      rateRepository.save(new RateEntity("KPW", 1056.310661));
      rateRepository.save(new RateEntity("KRW", 1348.833129));
      rateRepository.save(new RateEntity("KWD", 0.359085));
      rateRepository.save(new RateEntity("KYD", 0.978156));
      rateRepository.save(new RateEntity("KZT", 503.472712));
      rateRepository.save(new RateEntity("LAK", 10832.634259));
      rateRepository.save(new RateEntity("LBP", 1783.117455));
      rateRepository.save(new RateEntity("LKR", 216.382171));
      rateRepository.save(new RateEntity("LRD", 232.702088));
      rateRepository.save(new RateEntity("LSL", 19.317747));
      rateRepository.save(new RateEntity("LTL", 3.465434));
      rateRepository.save(new RateEntity("LVL", 0.709919));
      rateRepository.save(new RateEntity("LYD", 1.613766));
      rateRepository.save(new RateEntity("MAD", 10.80885));
      rateRepository.save(new RateEntity("MDL", 19.895216));
      rateRepository.save(new RateEntity("MGA", 4571.30088));
      rateRepository.save(new RateEntity("MKD", 61.543587));
      rateRepository.save(new RateEntity("MMK", 1519.429298));
      rateRepository.save(new RateEntity("MNT", 3341.595681));
      rateRepository.save(new RateEntity("MOP", 9.369534));
      rateRepository.save(new RateEntity("MRO", 418.986727));
      rateRepository.save(new RateEntity("MUR", 47.065191));
      rateRepository.save(new RateEntity("MVR", 18.086015));
      rateRepository.save(new RateEntity("MWK", 885.504073));
      rateRepository.save(new RateEntity("MXN", 25.053665));
      rateRepository.save(new RateEntity("MYR", 4.857374));
      rateRepository.save(new RateEntity("MZN", 85.275785));
      rateRepository.save(new RateEntity("NAD", 19.318048));
      rateRepository.save(new RateEntity("NGN", 450.135147));
      rateRepository.save(new RateEntity("NIO", 40.666629));
      rateRepository.save(new RateEntity("NOK", 10.825118));
      rateRepository.save(new RateEntity("NPR", 137.697437));
      rateRepository.save(new RateEntity("NZD", 1.766934));
      rateRepository.save(new RateEntity("OMR", 0.451884));
      rateRepository.save(new RateEntity("PAB", 1.173768));
      rateRepository.save(new RateEntity("PEN", 4.198675));
      rateRepository.save(new RateEntity("PGK", 4.109183));
      rateRepository.save(new RateEntity("PHP", 57.1853));
      rateRepository.save(new RateEntity("PKR", 192.236225));
      rateRepository.save(new RateEntity("PLN", 4.495543));
      rateRepository.save(new RateEntity("PYG", 8225.431674));
      rateRepository.save(new RateEntity("QAR", 4.27318));
      rateRepository.save(new RateEntity("RON", 4.87586));
      rateRepository.save(new RateEntity("RSD", 117.586737));
      rateRepository.save(new RateEntity("RUB", 90.422801));
      rateRepository.save(new RateEntity("RWF", 1141.358246));
      rateRepository.save(new RateEntity("SAR", 4.402572));
      rateRepository.save(new RateEntity("SBD", 9.545676));
      rateRepository.save(new RateEntity("SCR", 21.248506));
      rateRepository.save(new RateEntity("SDG", 64.872618));
      rateRepository.save(new RateEntity("SEK", 10.352771));
      rateRepository.save(new RateEntity("SGD", 1.596763));
      rateRepository.save(new RateEntity("SHP", 0.905855));
      rateRepository.save(new RateEntity("SLL", 11589.627471));
      rateRepository.save(new RateEntity("SOS", 684.227806));
      rateRepository.save(new RateEntity("SRD", 16.611625));
      rateRepository.save(new RateEntity("STD", 24683.742265));
      rateRepository.save(new RateEntity("SVC", 10.270342));
      rateRepository.save(new RateEntity("SYP", 601.490905));
      rateRepository.save(new RateEntity("SZL", 19.318052));
      rateRepository.save(new RateEntity("THB", 36.687682));
      rateRepository.save(new RateEntity("TJS", 12.13079));
      rateRepository.save(new RateEntity("TMT", 4.107716));
      rateRepository.save(new RateEntity("TND", 3.230426));
      rateRepository.save(new RateEntity("TOP", 2.711151));
      rateRepository.save(new RateEntity("TRY", 9.293645));
      rateRepository.save(new RateEntity("TTD", 7.958743));
      rateRepository.save(new RateEntity("TWD", 33.74671));
      rateRepository.save(new RateEntity("TZS", 2722.829241));
      rateRepository.save(new RateEntity("UAH", 33.240786));
      rateRepository.save(new RateEntity("UGX", 4348.706672));
      rateRepository.save(new RateEntity("USD", 1.173633));
      rateRepository.save(new RateEntity("UYU", 49.984917));
      rateRepository.save(new RateEntity("UZS", 12111.893905));
      rateRepository.save(new RateEntity("VEF", 11.721663));
      rateRepository.save(new RateEntity("VND", 27201.882508));
      rateRepository.save(new RateEntity("VUV", 132.697826));
      rateRepository.save(new RateEntity("WST", 3.073876));
      rateRepository.save(new RateEntity("XAF", 652.990449));
      rateRepository.save(new RateEntity("XAG", 0.048809));
      rateRepository.save(new RateEntity("XAU", 6.2E-4));
      rateRepository.save(new RateEntity("XCD", 3.171802));
      rateRepository.save(new RateEntity("XDR", 0.829731));
      rateRepository.save(new RateEntity("XOF", 654.887426));
      rateRepository.save(new RateEntity("XPF", 118.948337));
      rateRepository.save(new RateEntity("YER", 293.818671));
      rateRepository.save(new RateEntity("ZAR", 19.359313));
      rateRepository.save(new RateEntity("ZMK", 10564.11485));
      rateRepository.save(new RateEntity("ZMW", 23.586645));
      rateRepository.save(new RateEntity("ZWL", 377.909999));

      ///////////////////////////////
      countryRepository.save(new CountryEntity("AD",
          "ANDORRA",
          "ANDORRA LA VELLA",
          "EUR",
          1.0,
          "ES,FR"));
      countryRepository.save(new CountryEntity("AE",
          "UNITED ARAB EMIRATES",
          "ABU DHABI",
          "AED",
          4.310791,
          "SA,OM"));
      countryRepository.save(new CountryEntity("AF",
          "AFGHANISTAN",
          "KABUL",
          "AFN",
          90.311162,
          "TM,CN,IR,TJ,PK,UZ"));
      countryRepository.save(new CountryEntity("AL",
          "ALBANIA",
          "TIRANA",
          "ALL",
          123.113381,
          "MK,GR,ME,RS,XK"));
      countryRepository.save(new CountryEntity("AM",
          "ARMENIA",
          "YEREVAN",
          "AMD",
          576.242194,
          "GE,IR,AZ,TR"));
      countryRepository.save(new CountryEntity("AO",
          "ANGOLA",
          "LUANDA",
          "AOA",
          755.97184,
          "CD,NA,ZM,CG"));
      countryRepository.save(new CountryEntity("AR",
          "ARGENTINA",
          "BUENOS AIRES",
          "ARS",
          90.85255,
          "CL,BO,UY,PY,BR"));
      countryRepository.save(new CountryEntity("AT",
          "AUSTRIA",
          "VIENNA",
          "EUR",
          1.0,
          "CH,DE,HU,SK,CZ,IT,SI,LI"));
      countryRepository.save(new CountryEntity("AZ",
          "AZERBAIJAN",
          "BAKU",
          "AZN",
          1.992496,
          "GE,IR,AM,TR,RU"));
      countryRepository.save(new CountryEntity("BA",
          "BOSNIA AND HERZEGOVINA",
          "SARAJEVO",
          "BAM",
          1.946985,
          "HR,ME,RS"));
      countryRepository.save(new CountryEntity("BD",
          "BANGLADESH",
          "DHAKA",
          "BDT",
          99.528739,
          "MM,IN"));
      countryRepository.save(new CountryEntity("BE",
          "BELGIUM",
          "BRUSSELS",
          "EUR",
          1.0,
          "DE,NL,LU,FR"));
      countryRepository.save(new CountryEntity("BF",
          "BURKINA FASO",
          "OUAGADOUGOU",
          "XOF",
          654.887426,
          "NE,BJ,GH,CI,TG,ML"));
      countryRepository.save(new CountryEntity("BG",
          "BULGARIA",
          "SOFIA",
          "BGN",
          1.952835,
          "MK,GR,RO,TR,RS"));
      countryRepository.save(new CountryEntity("BI",
          "BURUNDI",
          "BUJUMBURA",
          "BIF",
          2268.046077,
          "TZ,CD,RW"));
      countryRepository.save(new CountryEntity("BJ",
          "BENIN",
          "PORTO-NOVO",
          "XOF",
          654.887426,
          "NE,TG,BF,NG"));
      countryRepository.save(new CountryEntity("BN",
          "BRUNEI",
          "BANDAR SERI BEGAWAN",
          "BND",
          1.593859,
          "MY"));
      countryRepository.save(new CountryEntity("BO",
          "BOLIVIA",
          "SUCRE",
          "BOB",
          8.110653,
          "PE,CL,PY,BR,AR"));
      countryRepository.save(new CountryEntity("BR",
          "BRAZIL",
          "BRASILIA",
          "BRL",
          6.541711,
          "SR,PE,BO,UY,GY,PY,GF,VE,CO,AR"));
      countryRepository.save(new CountryEntity("BT",
          "BHUTAN",
          "THIMPHU",
          "BTN",
          86.060625,
          "CN,IN"));
      countryRepository.save(new CountryEntity("BW",
          "BOTSWANA",
          "GABORONE",
          "BWP",
          13.437453,
          "ZW,ZA,NA"));
      countryRepository.save(new CountryEntity("BY",
          "BELARUS",
          "MINSK",
          "BYR",
          23003.209887,
          "PL,LT,UA,RU,LV"));
      countryRepository.save(new CountryEntity("BZ",
          "BELIZE",
          "BELMOPAN",
          "BZD",
          2.365951,
          "GT,MX"));
      countryRepository.save(new CountryEntity("CA",
          "CANADA",
          "OTTAWA",
          "CAD",
          1.541186,
          "US"));
      countryRepository.save(new CountryEntity("CD",
          "DEMOCRATIC REPUBLIC OF THE CONGO",
          "KINSHASA",
          "CDF",
          2297.63442,
          "TZ,CF,SS,RW,ZM,BI,UG,CG,AO"));
      countryRepository.save(new CountryEntity("CF",
          "CENTRAL AFRICAN REPUBLIC",
          "BANGUI",
          "XAF",
          652.990449,
          "TD,SD,CD,SS,CM,CG"));
      countryRepository.save(new CountryEntity("CG",
          "REPUBLIC OF THE CONGO",
          "BRAZZAVILLE",
          "XAF",
          652.990449,
          "CF,GA,CD,CM,AO"));
      countryRepository.save(new CountryEntity("CH",
          "SWITZERLAND",
          "BERNE",
          "CHF",
          1.073522,
          "DE,IT,LI,FR,AT"));
      countryRepository.save(new CountryEntity("CI",
          "IVORY COAST",
          "YAMOUSSOUKRO",
          "XOF",
          654.887426,
          "LR,GH,GN,BF,ML"));
      countryRepository.save(new CountryEntity("CL",
          "CHILE",
          "SANTIAGO",
          "CLP",
          936.103306,
          "PE,BO,AR"));
      countryRepository.save(new CountryEntity("CM",
          "CAMEROON",
          "YAOUNDE",
          "XAF",
          652.990449,
          "TD,CF,GA,GQ,CG,NG"));
      countryRepository.save(new CountryEntity("CN",
          "CHINA",
          "BEIJING",
          "CNY",
          7.918034,
          "LA,BT,TJ,KZ,MN,AF,NP,MM,KG,PK,KP,RU,VN,IN"));
      countryRepository.save(new CountryEntity("CO",
          "COLOMBIA",
          "BOGOTA",
          "COP",
          4524.144568,
          "EC,PE,PA,BR,VE"));
      countryRepository.save(new CountryEntity("CR",
          "COSTA RICA",
          "SAN JOSE",
          "CRC",
          707.525694,
          "PA,NI"));
      countryRepository.save(new CountryEntity("CU",
          "CUBA",
          "HAVANA",
          "CUP",
          31.101279,
          "US"));
      countryRepository.save(new CountryEntity("CZ",
          "CZECH REPUBLIC",
          "PRAGUE",
          "CZK",
          27.376401,
          "PL,DE,SK,AT"));
      countryRepository.save(new CountryEntity("DE",
          "GERMANY",
          "BERLIN",
          "EUR",
          1.0,
          "CH,PL,NL,DK,BE,CZ,LU,FR,AT"));
      countryRepository.save(new CountryEntity("DJ",
          "DJIBOUTI",
          "DJIBOUTI",
          "DJF",
          208.960687,
          "ER,ET,SO"));
      countryRepository.save(new CountryEntity("DK",
          "DENMARK",
          "COPENHAGEN",
          "DKK",
          7.443088,
          "DE"));
      countryRepository.save(new CountryEntity("DO",
          "DOMINICAN REPUBLIC",
          "SANTO DOMINGO",
          "DOP",
          68.663431,
          "HT"));
      countryRepository.save(new CountryEntity("DZ",
          "ALGERIA",
          "ALGIERS",
          "DZD",
          151.463445,
          "NE,EH,LY,MR,TN,MA,ML"));
      countryRepository.save(new CountryEntity("EC",
          "ECUADOR",
          "QUITO",
          "USD",
          1.173633,
          "PE,CO"));
      countryRepository.save(new CountryEntity("EE",
          "ESTONIA",
          "TALLINN",
          "EUR",
          1.0,
          "RU,LV"));
      countryRepository.save(new CountryEntity("EG",
          "EGYPT",
          "CAIRO",
          "EGP",
          18.413832,
          "LY,SD,IL,PS"));
      countryRepository.save(new CountryEntity("EH",
          "WESTERN SAHARA",
          "EL-AAIUN",
          "MAD",
          10.80885,
          "DZ,MR,MA"));
      countryRepository.save(new CountryEntity("ER",
          "ERITREA",
          "ASMARA",
          "ERN",
          17.604348,
          "ET,SD,DJ"));
      countryRepository.save(new CountryEntity("ES",
          "SPAIN",
          "MADRID",
          "EUR",
          1.0,
          "AD,PT,GI,FR,MA"));
      countryRepository.save(new CountryEntity("ET",
          "ETHIOPIA",
          "ADDIS ABABA",
          "ETB",
          43.365635,
          "ER,KE,SD,SS,SO,DJ"));
      countryRepository.save(new CountryEntity("FI",
          "FINLAND",
          "HELSINKI",
          "EUR",
          1.0,
          "NO,RU,SE"));
      countryRepository.save(new CountryEntity("FR",
          "FRANCE",
          "PARIS",
          "EUR",
          1.0,
          "CH,DE,BE,LU,IT,AD,MC,ES"));
      countryRepository.save(new CountryEntity("GA",
          "GABON",
          "LIBREVILLE",
          "XAF",
          652.990449,
          "CM,GQ,CG"));
      countryRepository.save(new CountryEntity("GB",
          "UNITED KINGDOM",
          "LONDON",
          "GBP",
          0.905828,
          "IE"));
      countryRepository.save(new CountryEntity("GE",
          "GEORGIA",
          "TBILISI",
          "GEL",
          3.761505,
          "AM,AZ,TR,RU"));
      countryRepository.save(new CountryEntity("GF",
          "FRENCH GUIANA",
          "CAYENNE",
          "EUR",
          1.0,
          "SR,BR"));
      countryRepository.save(new CountryEntity("GH",
          "GHANA",
          "ACCRA",
          "GHS",
          6.836461,
          "CI,TG,BF"));
      countryRepository.save(new CountryEntity("GI",
          "GIBRALTAR",
          "GIBRALTAR",
          "GIP",
          0.905855,
          "ES"));
      countryRepository.save(new CountryEntity("GM",
          "GAMBIA",
          "BANJUL",
          "GMD",
          60.74726,
          "SN"));
      countryRepository.save(new CountryEntity("GN",
          "GUINEA",
          "CONAKRY",
          "GNF",
          11460.527516,
          "LR,SN,SL,CI,GW,ML"));
      countryRepository.save(new CountryEntity("GQ",
          "EQUATORIAL GUINEA",
          "MALABO",
          "XAF",
          652.990449,
          "GA,CM"));
      countryRepository.save(new CountryEntity("GR",
          "GREECE",
          "ATHENS",
          "EUR",
          1.0,
          "AL,MK,TR,BG"));
      countryRepository.save(new CountryEntity("GT",
          "GUATEMALA",
          "GUATEMALA CITY",
          "GTQ",
          9.131814,
          "MX,HN,BZ,SV"));
      countryRepository.save(new CountryEntity("GW",
          "GUINEA-BISSAU",
          "BISSAU",
          "XOF",
          654.887426,
          "SN,GN"));
      countryRepository.save(new CountryEntity("GY",
          "GUYANA",
          "GEORGETOWN",
          "GYD",
          245.564395,
          "SR,BR,VE"));
      countryRepository.save(new CountryEntity("HN",
          "HONDURAS",
          "TEGUCIGALPA",
          "HNL",
          28.865527,
          "GT,NI,SV"));
      countryRepository.save(new CountryEntity("HR",
          "CROATIA",
          "ZAGREB",
          "HRK",
          7.581083,
          "HU,SI,BA,ME,RS"));
      countryRepository.save(new CountryEntity("HT",
          "HAITI",
          "PORT-AU-PRINCE",
          "HTG",
          73.947057,
          "DO"));
      countryRepository.save(new CountryEntity("HU",
          "HUNGARY",
          "BUDAPEST",
          "HUF",
          361.796478,
          "SK,SI,RO,UA,HR,AT,RS"));
      countryRepository.save(new CountryEntity("ID",
          "INDONESIA",
          "JAKARTA",
          "IDR",
          17347.823791,
          "PG,TL,MY"));
      countryRepository.save(new CountryEntity("IE",
          "IRELAND",
          "DUBLIN",
          "EUR",
          1.0,
          "GB"));
      countryRepository.save(new CountryEntity("IL",
          "ISRAEL",
          "JERUSALEM",
          "ILS",
          3.977584,
          "SY,JO,LB,EG,PS"));
      countryRepository.save(new CountryEntity("IN",
          "INDIA",
          "NEW DELHI",
          "INR",
          86.175951,
          "CN,NP,MM,BT,PK,BD"));
      countryRepository.save(new CountryEntity("IQ",
          "IRAQ",
          "BAGHDAD",
          "IQD",
          1396.623457,
          "SY,SA,IR,JO,TR,KW"));
      countryRepository.save(new CountryEntity("IR",
          "IRAN",
          "TEHRAN",
          "IRR",
          49415.824189,
          "TM,AF,IQ,AM,PK,AZ,TR"));
      countryRepository.save(new CountryEntity("IT",
          "ITALY",
          "ROME",
          "EUR",
          1.0,
          "CH,VA,SI,SM,FR,AT"));
      countryRepository.save(new CountryEntity("JO",
          "JORDAN",
          "AMMAN",
          "JOD",
          0.832102,
          "SY,SA,IQ,IL,PS"));
      countryRepository.save(new CountryEntity("KE",
          "KENYA",
          "NAIROBI",
          "KES",
          127.526822,
          "ET,TZ,SS,SO,UG"));
      countryRepository.save(new CountryEntity("KG",
          "KYRGYZSTAN",
          "BISHKEK",
          "KGS",
          93.489153,
          "CN,TJ,UZ,KZ"));
      countryRepository.save(new CountryEntity("KH",
          "CAMBODIA",
          "PHNOM PENH",
          "KHR",
          4814.832675,
          "LA,TH,VN"));
      countryRepository.save(new CountryEntity("KP",
          "NORTH KOREA",
          "PYONGYANG",
          "KPW",
          1056.310661,
          "CN,KR,RU"));
      countryRepository.save(new CountryEntity("KR",
          "SOUTH KOREA",
          "SEOUL",
          "KRW",
          1348.833129,
          "KP"));
      countryRepository.save(new CountryEntity("XK",
          "KOSOVO",
          "PRISTINA",
          "EUR",
          1.0,
          "RS,AL,MK,ME"));
      countryRepository.save(new CountryEntity("KW",
          "KUWAIT",
          "KUWAIT CITY",
          "KWD",
          0.359085,
          "SA,IQ"));
      countryRepository.save(new CountryEntity("KZ",
          "KAZAKHSTAN",
          "ASTANA",
          "KZT",
          503.472712,
          "TM,CN,KG,UZ,RU"));
      countryRepository.save(new CountryEntity("LA",
          "LAOS",
          "VIENTIANE",
          "LAK",
          10832.634259,
          "CN,MM,KH,TH,VN"));
      countryRepository.save(new CountryEntity("LB",
          "LEBANON",
          "BEIRUT",
          "LBP",
          1783.117455,
          "SY,IL"));
      countryRepository.save(new CountryEntity("LI",
          "LIECHTENSTEIN",
          "VADUZ",
          "CHF",
          1.073522,
          "CH,AT"));
      countryRepository.save(new CountryEntity("LR",
          "LIBERIA",
          "MONROVIA",
          "LRD",
          232.702088,
          "SL,CI,GN"));
      countryRepository.save(new CountryEntity("LS",
          "LESOTHO",
          "MASERU",
          "LSL",
          19.317747,
          "ZA"));
      countryRepository.save(new CountryEntity("LT",
          "LITHUANIA",
          "VILNIUS",
          "EUR",
          1.0,
          "PL,BY,RU,LV"));
      countryRepository.save(new CountryEntity("LU",
          "LUXEMBOURG",
          "LUXEMBOURG",
          "EUR",
          1.0,
          "DE,BE,FR"));
      countryRepository.save(new CountryEntity("LV",
          "LATVIA",
          "RIGA",
          "EUR",
          1.0,
          "LT,EE,BY,RU"));
      countryRepository.save(new CountryEntity("LY",
          "LIBYA",
          "TRIPOLIS",
          "LYD",
          1.613766,
          "TD,NE,DZ,SD,TN,EG"));
      countryRepository.save(new CountryEntity("MA",
          "MOROCCO",
          "RABAT",
          "MAD",
          10.80885,
          "DZ,EH,ES"));
      countryRepository.save(new CountryEntity("MC",
          "MONACO",
          "MONACO",
          "EUR",
          1.0,
          "FR"));
      countryRepository.save(new CountryEntity("MD",
          "MOLDOVA",
          "CHISINAU",
          "MDL",
          19.895216,
          "RO,UA"));
      countryRepository.save(new CountryEntity("ME",
          "MONTENEGRO",
          "PODGORICA",
          "EUR",
          1.0,
          "AL,HR,BA,RS,XK"));
      countryRepository.save(new CountryEntity("MF",
          "SAINT MARTIN",
          "MARIGOT",
          "EUR",
          1.0,
          "SX"));
      countryRepository.save(new CountryEntity("MK",
          "MACEDONIA",
          "SKOPJE",
          "MKD",
          61.543587,
          "AL,GR,BG,RS,XK"));
      countryRepository.save(new CountryEntity("ML",
          "MALI",
          "BAMAKO",
          "XOF",
          654.887426,
          "SN,NE,DZ,CI,GN,MR,BF"));
      countryRepository.save(new CountryEntity("MM",
          "MYANMAR",
          "NAY PYI TAW",
          "MMK",
          1519.429298,
          "CN,LA,TH,BD,IN"));
      countryRepository.save(new CountryEntity("MN",
          "MONGOLIA",
          "ULAN BATOR",
          "MNT",
          3341.595681,
          "CN,RU"));
      countryRepository.save(new CountryEntity("MR",
          "MAURITANIA",
          "NOUAKCHOTT",
          "MRO",
          418.986727,
          "SN,DZ,EH,ML"));
      countryRepository.save(new CountryEntity("MW",
          "MALAWI",
          "LILONGWE",
          "MWK",
          885.504073,
          "TZ,MZ,ZM"));
      countryRepository.save(new CountryEntity("MX",
          "MEXICO",
          "MEXICO CITY",
          "MXN",
          25.053665,
          "GT,US,BZ"));
      countryRepository.save(new CountryEntity("MY",
          "MALAYSIA",
          "KUALA LUMPUR",
          "MYR",
          4.857374,
          "BN,TH,ID"));
      countryRepository.save(new CountryEntity("MZ",
          "MOZAMBIQUE",
          "MAPUTO",
          "MZN",
          85.275785,
          "ZW,TZ,SZ,ZA,ZM,MW"));
      countryRepository.save(new CountryEntity("NA",
          "NAMIBIA",
          "WINDHOEK",
          "NAD",
          19.318048,
          "ZA,BW,ZM,AO"));
      countryRepository.save(new CountryEntity("NE",
          "NIGER",
          "NIAMEY",
          "XOF",
          654.887426,
          "TD,BJ,DZ,LY,BF,NG,ML"));
      countryRepository.save(new CountryEntity("NG",
          "NIGERIA",
          "ABUJA",
          "NGN",
          450.135147,
          "TD,NE,BJ,CM"));
      countryRepository.save(new CountryEntity("NI",
          "NICARAGUA",
          "MANAGUA",
          "NIO",
          40.666629,
          "CR,HN"));
      countryRepository.save(new CountryEntity("NL",
          "NETHERLANDS",
          "AMSTERDAM",
          "EUR",
          1.0,
          "DE,BE"));
      countryRepository.save(new CountryEntity("NO",
          "NORWAY",
          "OSLO",
          "NOK",
          10.825118,
          "FI,RU,SE"));
      countryRepository.save(new CountryEntity("NP",
          "NEPAL",
          "KATHMANDU",
          "NPR",
          137.697437,
          "CN,IN"));
      countryRepository.save(new CountryEntity("OM",
          "OMAN",
          "MUSCAT",
          "OMR",
          0.451884,
          "SA,YE,AE"));
      countryRepository.save(new CountryEntity("PA",
          "PANAMA",
          "PANAMA CITY",
          "PAB",
          1.173768,
          "CR,CO"));
      countryRepository.save(new CountryEntity("PE",
          "PERU",
          "LIMA",
          "PEN",
          4.198675,
          "EC,CL,BO,BR,CO"));
      countryRepository.save(new CountryEntity("PG",
          "PAPUA NEW GUINEA",
          "PORT MORESBY",
          "PGK",
          4.109183,
          "ID"));
      countryRepository.save(new CountryEntity("PK",
          "PAKISTAN",
          "ISLAMABAD",
          "PKR",
          192.236225,
          "CN,AF,IR,IN"));
      countryRepository.save(new CountryEntity("PL",
          "POLAND",
          "WARSAW",
          "PLN",
          4.495543,
          "DE,LT,SK,CZ,BY,UA,RU"));
      countryRepository.save(new CountryEntity("PS",
          "PALESTINIAN TERRITORY",
          "EAST JERUSALEM",
          "ILS",
          3.977584,
          "JO,IL,EG"));
      countryRepository.save(new CountryEntity("PT",
          "PORTUGAL",
          "LISBON",
          "EUR",
          1.0,
          "ES"));
      countryRepository.save(new CountryEntity("PY",
          "PARAGUAY",
          "ASUNCION",
          "PYG",
          8225.431674,
          "BO,BR,AR"));
      countryRepository.save(new CountryEntity("QA",
          "QATAR",
          "DOHA",
          "QAR",
          4.27318,
          "SA"));
      countryRepository.save(new CountryEntity("RO",
          "ROMANIA",
          "BUCHAREST",
          "RON",
          4.87586,
          "MD,HU,UA,BG,RS"));
      countryRepository.save(new CountryEntity("RS",
          "SERBIA",
          "BELGRADE",
          "RSD",
          117.586737,
          "AL,HU,MK,RO,HR,BA,BG,ME,XK"));
      countryRepository.save(new CountryEntity("RU",
          "RUSSIA",
          "MOSCOW",
          "RUB",
          90.422801,
          "GE,CN,BY,UA,KZ,LV,PL,EE,LT,FI,MN,NO,AZ,KP"));
      countryRepository.save(new CountryEntity("RW",
          "RWANDA",
          "KIGALI",
          "RWF",
          1141.358246,
          "TZ,CD,BI,UG"));
      countryRepository.save(new CountryEntity("SA",
          "SAUDI ARABIA",
          "RIYADH",
          "SAR",
          4.402572,
          "QA,OM,IQ,YE,JO,AE,KW"));
      countryRepository.save(new CountryEntity("SD",
          "SUDAN",
          "KHARTOUM",
          "SDG",
          64.872618,
          "SS,TD,EG,ET,ER,LY,CF"));
      countryRepository.save(new CountryEntity("SS",
          "SOUTH SUDAN",
          "JUBA",
          "USD",
          1.173633,
          "CD,CF,ET,KE,SD,UG"));
      countryRepository.save(new CountryEntity("SE",
          "SWEDEN",
          "STOCKHOLM",
          "SEK",
          10.352771,
          "NO,FI"));
      countryRepository.save(new CountryEntity("SI",
          "SLOVENIA",
          "LJUBLJANA",
          "EUR",
          1.0,
          "HU,IT,HR,AT"));
      countryRepository.save(new CountryEntity("SK",
          "SLOVAKIA",
          "BRATISLAVA",
          "EUR",
          1.0,
          "PL,HU,CZ,UA,AT"));
      countryRepository.save(new CountryEntity("SL",
          "SIERRA LEONE",
          "FREETOWN",
          "SLL",
          11589.627471,
          "LR,GN"));
      countryRepository.save(new CountryEntity("SM",
          "SAN MARINO",
          "SAN MARINO",
          "EUR",
          1.0,
          "IT"));
      countryRepository.save(new CountryEntity("SN",
          "SENEGAL",
          "DAKAR",
          "XOF",
          654.887426,
          "GN,MR,GW,GM,ML"));
      countryRepository.save(new CountryEntity("SO",
          "SOMALIA",
          "MOGADISHU",
          "SOS",
          684.227806,
          "ET,KE,DJ"));
      countryRepository.save(new CountryEntity("SR",
          "SURINAME",
          "PARAMARIBO",
          "SRD",
          16.611625,
          "GY,BR,GF"));
      countryRepository.save(new CountryEntity("SV",
          "EL SALVADOR",
          "SAN SALVADOR",
          "USD",
          1.173633,
          "GT,HN"));
      countryRepository.save(new CountryEntity("SX",
          "SINT MAARTEN",
          "PHILIPSBURG",
          "ANG",
          2.106928,
          "MF"));
      countryRepository.save(new CountryEntity("SY",
          "SYRIA",
          "DAMASCUS",
          "SYP",
          601.490905,
          "IQ,JO,IL,TR,LB"));
      countryRepository.save(new CountryEntity("SZ",
          "SWAZILAND",
          "MBABANE",
          "SZL",
          19.318052,
          "ZA,MZ"));
      countryRepository.save(new CountryEntity("TD",
          "CHAD",
          "N'DJAMENA",
          "XAF",
          652.990449,
          "NE,LY,CF,SD,CM,NG"));
      countryRepository.save(new CountryEntity("TG",
          "TOGO",
          "LOME",
          "XOF",
          654.887426,
          "BJ,GH,BF"));
      countryRepository.save(new CountryEntity("TH",
          "THAILAND",
          "BANGKOK",
          "THB",
          36.687682,
          "LA,MM,KH,MY"));
      countryRepository.save(new CountryEntity("TJ",
          "TAJIKISTAN",
          "DUSHANBE",
          "TJS",
          12.13079,
          "CN,AF,KG,UZ"));
      countryRepository.save(new CountryEntity("TL",
          "EAST TIMOR",
          "DILI",
          "USD",
          1.173633,
          "ID"));
      countryRepository.save(new CountryEntity("TM",
          "TURKMENISTAN",
          "ASHGABAT",
          "TMT",
          4.107716,
          "AF,IR,UZ,KZ"));
      countryRepository.save(new CountryEntity("TN",
          "TUNISIA",
          "TUNIS",
          "TND",
          3.230426,
          "DZ,LY"));
      countryRepository.save(new CountryEntity("TR",
          "TURKEY",
          "ANKARA",
          "TRY",
          9.293645,
          "SY,GE,IQ,IR,GR,AM,AZ,BG"));
      countryRepository.save(new CountryEntity("TZ",
          "TANZANIA",
          "DODOMA",
          "TZS",
          2722.829241,
          "MZ,KE,CD,RW,ZM,BI,UG,MW"));
      countryRepository.save(new CountryEntity("UA",
          "UKRAINE",
          "KIEV",
          "UAH",
          33.240786,
          "PL,MD,HU,SK,BY,RO,RU"));
      countryRepository.save(new CountryEntity("UG",
          "UGANDA",
          "KAMPALA",
          "UGX",
          4348.706672,
          "TZ,KE,SS,CD,RW"));
      countryRepository.save(new CountryEntity("US",
          "UNITED STATES",
          "WASHINGTON",
          "USD",
          1.173633,
          "CA,MX,CU"));
      countryRepository.save(new CountryEntity("UY",
          "URUGUAY",
          "MONTEVIDEO",
          "UYU",
          49.984917,
          "BR,AR"));
      countryRepository.save(new CountryEntity("UZ",
          "UZBEKISTAN",
          "TASHKENT",
          "UZS",
          12111.893905,
          "TM,AF,KG,TJ,KZ"));
      countryRepository.save(new CountryEntity("VA",
          "VATICAN",
          "VATICAN CITY",
          "EUR",
          1.0,
          "IT"));
      countryRepository.save(new CountryEntity("VE",
          "VENEZUELA",
          "CARACAS",
          "VEF",
          11.721663,
          "GY,BR,CO"));
      countryRepository.save(new CountryEntity("VN",
          "VIETNAM",
          "HANOI",
          "VND",
          27201.882508,
          "CN,LA,KH"));
      countryRepository.save(new CountryEntity("YE",
          "YEMEN",
          "SANAA",
          "YER",
          293.818671,
          "SA,OM"));
      countryRepository.save(new CountryEntity("ZA",
          "SOUTH AFRICA",
          "PRETORIA",
          "ZAR",
          19.359313,
          "ZW,SZ,MZ,BW,NA,LS"));
      countryRepository.save(new CountryEntity("ZM",
          "ZAMBIA",
          "LUSAKA",
          "ZMW",
          23.586645,
          "ZW,TZ,MZ,CD,NA,MW,AO"));
      countryRepository.save(new CountryEntity("ZW",
          "ZIMBABWE",
          "HARARE",
          "ZWL",
          377.909999,
          "ZA,MZ,BW,ZM"));
      countryRepository.save(new CountryEntity("CS",
          "SERBIA AND MONTENEGRO",
          "BELGRADE",
          "RSD",
          117.586737,
          "AL,HU,MK,RO,HR,BA,BG"));


    };
  }


}
