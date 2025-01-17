PGDMP      /                |         	   libraryDb    15.7    16.3 N    I           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            J           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            K           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            L           1262    25109 	   libraryDb    DATABASE     �   CREATE DATABASE "libraryDb" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE "libraryDb";
                postgres    false            �            1259    25218    authors    TABLE     �   CREATE TABLE public.authors (
    author_id integer NOT NULL,
    author_birthdate integer NOT NULL,
    author_country character varying(255) NOT NULL,
    author_name character varying(255) NOT NULL
);
    DROP TABLE public.authors;
       public         heap    postgres    false            �            1259    25217    authors_author_id_seq    SEQUENCE     �   CREATE SEQUENCE public.authors_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.authors_author_id_seq;
       public          postgres    false    232            M           0    0    authors_author_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.authors_author_id_seq OWNED BY public.authors.author_id;
          public          postgres    false    231            �            1259    25191    book_borrowings    TABLE     �   CREATE TABLE public.book_borrowings (
    borrowing_id integer NOT NULL,
    borrower_name character varying(255) NOT NULL,
    borrowing_date date,
    return_date date,
    book_id integer NOT NULL
);
 #   DROP TABLE public.book_borrowings;
       public         heap    postgres    false            �            1259    25190    book_borrowings_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.book_borrowings_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.book_borrowings_book_id_seq;
       public          postgres    false    228            N           0    0    book_borrowings_book_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.book_borrowings_book_id_seq OWNED BY public.book_borrowings.book_id;
          public          postgres    false    227            �            1259    25189     book_borrowings_borrowing_id_seq    SEQUENCE     �   CREATE SEQUENCE public.book_borrowings_borrowing_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.book_borrowings_borrowing_id_seq;
       public          postgres    false    228            O           0    0     book_borrowings_borrowing_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.book_borrowings_borrowing_id_seq OWNED BY public.book_borrowings.borrowing_id;
          public          postgres    false    226            �            1259    25121    book_category    TABLE     f   CREATE TABLE public.book_category (
    book_id integer NOT NULL,
    category_id integer NOT NULL
);
 !   DROP TABLE public.book_category;
       public         heap    postgres    false            �            1259    25119    book_category_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.book_category_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.book_category_book_id_seq;
       public          postgres    false    216            P           0    0    book_category_book_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.book_category_book_id_seq OWNED BY public.book_category.book_id;
          public          postgres    false    214            �            1259    25120    book_category_category_id_seq    SEQUENCE     �   CREATE SEQUENCE public.book_category_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.book_category_category_id_seq;
       public          postgres    false    216            Q           0    0    book_category_category_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.book_category_category_id_seq OWNED BY public.book_category.category_id;
          public          postgres    false    215            �            1259    25128    bookborrowings    TABLE     �   CREATE TABLE public.bookborrowings (
    book_id integer NOT NULL,
    borrowing_date date,
    borrowing_id integer NOT NULL,
    return_date date,
    borrower_name character varying(255) NOT NULL
);
 "   DROP TABLE public.bookborrowings;
       public         heap    postgres    false            �            1259    25126    bookborrowings_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bookborrowings_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.bookborrowings_book_id_seq;
       public          postgres    false    219            R           0    0    bookborrowings_book_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.bookborrowings_book_id_seq OWNED BY public.bookborrowings.book_id;
          public          postgres    false    217            �            1259    25127    bookborrowings_borrowing_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bookborrowings_borrowing_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.bookborrowings_borrowing_id_seq;
       public          postgres    false    219            S           0    0    bookborrowings_borrowing_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.bookborrowings_borrowing_id_seq OWNED BY public.bookborrowings.borrowing_id;
          public          postgres    false    218            �            1259    25138    books    TABLE     �   CREATE TABLE public.books (
    author_id integer NOT NULL,
    book_id integer NOT NULL,
    book_publication_year integer,
    book_stock integer,
    publisher_id integer NOT NULL,
    book_name character varying(255) NOT NULL
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    25135    books_author_id_seq    SEQUENCE     �   CREATE SEQUENCE public.books_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.books_author_id_seq;
       public          postgres    false    223            T           0    0    books_author_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.books_author_id_seq OWNED BY public.books.author_id;
          public          postgres    false    220            �            1259    25136    books_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.books_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.books_book_id_seq;
       public          postgres    false    223            U           0    0    books_book_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.books_book_id_seq OWNED BY public.books.book_id;
          public          postgres    false    221            �            1259    25137    books_publisher_id_seq    SEQUENCE     �   CREATE SEQUENCE public.books_publisher_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.books_publisher_id_seq;
       public          postgres    false    223            V           0    0    books_publisher_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.books_publisher_id_seq OWNED BY public.books.publisher_id;
          public          postgres    false    222            �            1259    25147 
   categories    TABLE     �   CREATE TABLE public.categories (
    category_id integer NOT NULL,
    category_description character varying(255),
    category_name character varying(255) NOT NULL
);
    DROP TABLE public.categories;
       public         heap    postgres    false            �            1259    25146    categories_category_id_seq    SEQUENCE     �   CREATE SEQUENCE public.categories_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.categories_category_id_seq;
       public          postgres    false    225            W           0    0    categories_category_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.categories_category_id_seq OWNED BY public.categories.category_id;
          public          postgres    false    224            �            1259    25204 
   publishers    TABLE     �   CREATE TABLE public.publishers (
    publisher_id integer NOT NULL,
    publisher_address character varying(255) NOT NULL,
    publisher_establishment_year integer NOT NULL,
    publisher_name character varying(255) NOT NULL
);
    DROP TABLE public.publishers;
       public         heap    postgres    false            �            1259    25203    publishers_publisher_id_seq    SEQUENCE     �   CREATE SEQUENCE public.publishers_publisher_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.publishers_publisher_id_seq;
       public          postgres    false    230            X           0    0    publishers_publisher_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.publishers_publisher_id_seq OWNED BY public.publishers.publisher_id;
          public          postgres    false    229            �           2604    25221    authors author_id    DEFAULT     v   ALTER TABLE ONLY public.authors ALTER COLUMN author_id SET DEFAULT nextval('public.authors_author_id_seq'::regclass);
 @   ALTER TABLE public.authors ALTER COLUMN author_id DROP DEFAULT;
       public          postgres    false    232    231    232            �           2604    25194    book_borrowings borrowing_id    DEFAULT     �   ALTER TABLE ONLY public.book_borrowings ALTER COLUMN borrowing_id SET DEFAULT nextval('public.book_borrowings_borrowing_id_seq'::regclass);
 K   ALTER TABLE public.book_borrowings ALTER COLUMN borrowing_id DROP DEFAULT;
       public          postgres    false    228    226    228            �           2604    25195    book_borrowings book_id    DEFAULT     �   ALTER TABLE ONLY public.book_borrowings ALTER COLUMN book_id SET DEFAULT nextval('public.book_borrowings_book_id_seq'::regclass);
 F   ALTER TABLE public.book_borrowings ALTER COLUMN book_id DROP DEFAULT;
       public          postgres    false    227    228    228            �           2604    25124    book_category book_id    DEFAULT     ~   ALTER TABLE ONLY public.book_category ALTER COLUMN book_id SET DEFAULT nextval('public.book_category_book_id_seq'::regclass);
 D   ALTER TABLE public.book_category ALTER COLUMN book_id DROP DEFAULT;
       public          postgres    false    216    214    216            �           2604    25125    book_category category_id    DEFAULT     �   ALTER TABLE ONLY public.book_category ALTER COLUMN category_id SET DEFAULT nextval('public.book_category_category_id_seq'::regclass);
 H   ALTER TABLE public.book_category ALTER COLUMN category_id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    25131    bookborrowings book_id    DEFAULT     �   ALTER TABLE ONLY public.bookborrowings ALTER COLUMN book_id SET DEFAULT nextval('public.bookborrowings_book_id_seq'::regclass);
 E   ALTER TABLE public.bookborrowings ALTER COLUMN book_id DROP DEFAULT;
       public          postgres    false    217    219    219            �           2604    25132    bookborrowings borrowing_id    DEFAULT     �   ALTER TABLE ONLY public.bookborrowings ALTER COLUMN borrowing_id SET DEFAULT nextval('public.bookborrowings_borrowing_id_seq'::regclass);
 J   ALTER TABLE public.bookborrowings ALTER COLUMN borrowing_id DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    25141    books author_id    DEFAULT     r   ALTER TABLE ONLY public.books ALTER COLUMN author_id SET DEFAULT nextval('public.books_author_id_seq'::regclass);
 >   ALTER TABLE public.books ALTER COLUMN author_id DROP DEFAULT;
       public          postgres    false    223    220    223            �           2604    25142    books book_id    DEFAULT     n   ALTER TABLE ONLY public.books ALTER COLUMN book_id SET DEFAULT nextval('public.books_book_id_seq'::regclass);
 <   ALTER TABLE public.books ALTER COLUMN book_id DROP DEFAULT;
       public          postgres    false    223    221    223            �           2604    25143    books publisher_id    DEFAULT     x   ALTER TABLE ONLY public.books ALTER COLUMN publisher_id SET DEFAULT nextval('public.books_publisher_id_seq'::regclass);
 A   ALTER TABLE public.books ALTER COLUMN publisher_id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    25150    categories category_id    DEFAULT     �   ALTER TABLE ONLY public.categories ALTER COLUMN category_id SET DEFAULT nextval('public.categories_category_id_seq'::regclass);
 E   ALTER TABLE public.categories ALTER COLUMN category_id DROP DEFAULT;
       public          postgres    false    225    224    225            �           2604    25207    publishers publisher_id    DEFAULT     �   ALTER TABLE ONLY public.publishers ALTER COLUMN publisher_id SET DEFAULT nextval('public.publishers_publisher_id_seq'::regclass);
 F   ALTER TABLE public.publishers ALTER COLUMN publisher_id DROP DEFAULT;
       public          postgres    false    229    230    230            F          0    25218    authors 
   TABLE DATA           [   COPY public.authors (author_id, author_birthdate, author_country, author_name) FROM stdin;
    public          postgres    false    232   �\       B          0    25191    book_borrowings 
   TABLE DATA           l   COPY public.book_borrowings (borrowing_id, borrower_name, borrowing_date, return_date, book_id) FROM stdin;
    public          postgres    false    228   ]       6          0    25121    book_category 
   TABLE DATA           =   COPY public.book_category (book_id, category_id) FROM stdin;
    public          postgres    false    216   -]       9          0    25128    bookborrowings 
   TABLE DATA           k   COPY public.bookborrowings (book_id, borrowing_date, borrowing_id, return_date, borrower_name) FROM stdin;
    public          postgres    false    219   T]       =          0    25138    books 
   TABLE DATA           o   COPY public.books (author_id, book_id, book_publication_year, book_stock, publisher_id, book_name) FROM stdin;
    public          postgres    false    223   q]       ?          0    25147 
   categories 
   TABLE DATA           V   COPY public.categories (category_id, category_description, category_name) FROM stdin;
    public          postgres    false    225   �]       D          0    25204 
   publishers 
   TABLE DATA           s   COPY public.publishers (publisher_id, publisher_address, publisher_establishment_year, publisher_name) FROM stdin;
    public          postgres    false    230   �]       Y           0    0    authors_author_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.authors_author_id_seq', 2, true);
          public          postgres    false    231            Z           0    0    book_borrowings_book_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.book_borrowings_book_id_seq', 1, false);
          public          postgres    false    227            [           0    0     book_borrowings_borrowing_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.book_borrowings_borrowing_id_seq', 1, false);
          public          postgres    false    226            \           0    0    book_category_book_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.book_category_book_id_seq', 1, false);
          public          postgres    false    214            ]           0    0    book_category_category_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.book_category_category_id_seq', 1, false);
          public          postgres    false    215            ^           0    0    bookborrowings_book_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.bookborrowings_book_id_seq', 1, false);
          public          postgres    false    217            _           0    0    bookborrowings_borrowing_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.bookborrowings_borrowing_id_seq', 1, false);
          public          postgres    false    218            `           0    0    books_author_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.books_author_id_seq', 1, false);
          public          postgres    false    220            a           0    0    books_book_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.books_book_id_seq', 2, true);
          public          postgres    false    221            b           0    0    books_publisher_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.books_publisher_id_seq', 1, false);
          public          postgres    false    222            c           0    0    categories_category_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.categories_category_id_seq', 4, true);
          public          postgres    false    224            d           0    0    publishers_publisher_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.publishers_publisher_id_seq', 2, true);
          public          postgres    false    229            �           2606    25225    authors authors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public            postgres    false    232            �           2606    25197 $   book_borrowings book_borrowings_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.book_borrowings
    ADD CONSTRAINT book_borrowings_pkey PRIMARY KEY (borrowing_id);
 N   ALTER TABLE ONLY public.book_borrowings DROP CONSTRAINT book_borrowings_pkey;
       public            postgres    false    228            �           2606    25134 "   bookborrowings bookborrowings_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.bookborrowings
    ADD CONSTRAINT bookborrowings_pkey PRIMARY KEY (borrowing_id);
 L   ALTER TABLE ONLY public.bookborrowings DROP CONSTRAINT bookborrowings_pkey;
       public            postgres    false    219            �           2606    25145    books books_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    223            �           2606    25154    categories categories_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);
 D   ALTER TABLE ONLY public.categories DROP CONSTRAINT categories_pkey;
       public            postgres    false    225            �           2606    25211    publishers publishers_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.publishers
    ADD CONSTRAINT publishers_pkey PRIMARY KEY (publisher_id);
 D   ALTER TABLE ONLY public.publishers DROP CONSTRAINT publishers_pkey;
       public            postgres    false    230            �           2606    25169 )   book_category fk5cagani7v0529ierdthg9w3oa    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fk5cagani7v0529ierdthg9w3oa FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fk5cagani7v0529ierdthg9w3oa;
       public          postgres    false    223    3223    216            �           2606    25212 !   books fkayy5edfrqnegqj3882nce6qo8    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkayy5edfrqnegqj3882nce6qo8 FOREIGN KEY (publisher_id) REFERENCES public.publishers(publisher_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fkayy5edfrqnegqj3882nce6qo8;
       public          postgres    false    223    3229    230            �           2606    25174 *   bookborrowings fketjwkrt2005wndw2ehy1cx0rg    FK CONSTRAINT     �   ALTER TABLE ONLY public.bookborrowings
    ADD CONSTRAINT fketjwkrt2005wndw2ehy1cx0rg FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 T   ALTER TABLE ONLY public.bookborrowings DROP CONSTRAINT fketjwkrt2005wndw2ehy1cx0rg;
       public          postgres    false    3223    223    219            �           2606    25226 !   books fkfjixh2vym2cvfj3ufxj91jem7    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkfjixh2vym2cvfj3ufxj91jem7 FOREIGN KEY (author_id) REFERENCES public.authors(author_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fkfjixh2vym2cvfj3ufxj91jem7;
       public          postgres    false    232    3231    223            �           2606    25164 )   book_category fkp8frvau07g2sa58kplr9lttr0    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fkp8frvau07g2sa58kplr9lttr0 FOREIGN KEY (category_id) REFERENCES public.categories(category_id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fkp8frvau07g2sa58kplr9lttr0;
       public          postgres    false    3225    225    216            �           2606    25198 +   book_borrowings fkpo78cf0ph5ya90glc7wv57wdj    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_borrowings
    ADD CONSTRAINT fkpo78cf0ph5ya90glc7wv57wdj FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 U   ALTER TABLE ONLY public.book_borrowings DROP CONSTRAINT fkpo78cf0ph5ya90glc7wv57wdj;
       public          postgres    false    228    223    3223            F   !   x�3�4�47�v�����Sp�O����� HA�      B      x������ � �      6      x�3�4�2�4bc�=... I      9      x������ � �      =   )   x�3�4�420��4�4�tMKKM.�,KU�J,K����� yY�      ?   (   x�3�tK�+I,���\F0��e�sI�K�M����� ^��      D   A   x�3�442Vp�H�-�IU.)JM-с�3K*���"SN#CN�\@iRNfqFjW� %aN     