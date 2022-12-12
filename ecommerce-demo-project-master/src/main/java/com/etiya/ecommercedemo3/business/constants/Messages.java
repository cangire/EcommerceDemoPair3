package com.etiya.ecommercedemo3.business.constants;

public class Messages {
    public static class Category {
        public static final String CategoryAddSuccessMessage = "Kategori Eklendi";
        public static final String CategoryGetByIdSuccessMessage = "İstenilen Kategori getirildi.";
        public static final String CategoryGetAllSuccessMessage = "Bütün Kategoriler Listelendi";
        public static final String CategoryExistWithSameName = "Bu isimle bir kategori zaten mevcut";

        public static final String CategoryNotExistWithId="Bu id'ye sahip bir kategori mevcut değil!";
    }

    public static class City {
        public static final String CityAddSuccessMessage = "Şehir Eklendi.";
        public static final String CityGetById = "İstenilen Şehir Getirildi.";
        public static final String CityNotExistWithId = "Bu id'ye sahip city mevcut değil!";
        public static final String getAllDtoCitiesSuccesMessage = "Şehirler Dto ile getirildi.";
    }

    public static class Country {
        public static final String countryAddSuccesMessage = "Ülke eklendi.";
        public static final String countryGetByIdSuccesMessage = "İstenilen Ülke Getirildi.";
        public static final String CountryNotExistWithId = "Bu id'ye sahip country mevcut değil!";

    }
    public static class Street {
        public static final String streetAddSuccessMessage = "Sokak eklendi";
        public static final String StreetNotExistWithId = "Bu id'ye sahip street mevcut değil!";
        public static final String streetGetByIdSuccessMessage = "id'e göre Sokak getirildi";

    }
    public static class Customer {
        public static final String customerGetByIdSuccessMessage = "İstenilen Müşteri Getirildi.";
        public static final String CustomerNotExistWithId = "Bu id'ye sahip customer mevcut değil!";

    }

    public static class Address {
        public static final String addressAddingSuccessMessage = "Adres Başarıyla eklendi";

        public static final String addressListAllSuccessMessage= "Adresler başarıyla listelendi";

        public static final String addressGetByIdSuccessMessage= "Adres başarıyla getirildi";

    }
    public static class Cart {
        public static final String cartAddSuccessMessage = "Sepet Başarıyla Oluşturuldu.";
    }

    public static class ProductCategory {
        public static final String productCategoriesAddSuccesMessage = "Eklendi";
        public static final String ProductCategoryNotExistWithId="Bu id'ye sahip bir kategori mevcut değil!";
    }

    public static class Product {
        public static final String productGetByNameSuccesMessage = "Ürün isme göre listelendi";
        public static final String productAllByStockGreaterThanSuccesMessage = "Ürün Stoka göre listelendi";
        public static final String productAddSuccesMessage = "Ürün eklendi";
        public static final String productGetByIdSuccesMessage = "Ürün Id'e Getirildi";
    }

    public static class PaymentType {
        public static final String paymentTypeGetByDescriptionSuccessMessage = "İstenilen Ödeme Yöntemi Açıklaması Getirildi";
        public static final String paymentTypeGetByNameSuccessMessage = "İstenilen Ödeme Yöntemi Adı ile Getirildi.";
        public static final String paymentTypeGetByIdSuccessMessage = "İstenilen Ödeme Yöntemi Getirildi.";
        public static final String paymentTypeGetAllSuccessMessage = "Ödeme Yöntemleri Listelendi.";
        public static final String paymentTypeAddSuccessMessage = "Ödeme Yöntemi Eklendi.";
    }


    public static class IndividualCustomer {
        public static final String individualCustomerAddSuccessMessage = "Bireysel Müşterilere Eklendi.";
        public static final String individualCustomerGetAllSuccessMessage = "Bireysel Müşteriler Listelendi.";
        public static final String individualCustomerGetByIdSuccessMessage = "Bireysel Müşteri Getirildi.";
        public static final String individualCustomerGetByFirstNameSuccessMessage = "Bireysel Müşteri Adına Göre Getirildi";
        public static final String individualCustomerGetByIdentityNumberSuccessMessage = "Bireysel Müşterilerin TC Kimlik no'suna göre getirildi.";
    }
public static class Order{
     public  static  final  String orderAddSuccessMessage="Sipariş eklendi";
}

}
