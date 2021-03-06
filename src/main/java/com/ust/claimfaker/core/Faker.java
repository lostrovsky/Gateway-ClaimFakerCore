package com.ust.claimfaker.core;

import java.util.Locale;
import java.util.Random;

import com.ust.claimfaker.core.Address;
import com.ust.claimfaker.core.Ancient;
import com.ust.claimfaker.core.App;
import com.ust.claimfaker.core.Artist;
import com.ust.claimfaker.core.Avatar;
import com.ust.claimfaker.core.Beer;
import com.ust.claimfaker.core.Book;
import com.ust.claimfaker.core.Bool;
import com.ust.claimfaker.core.Business;
import com.ust.claimfaker.core.Cat;
import com.ust.claimfaker.core.ChuckNorris;
import com.ust.claimfaker.core.Code;
import com.ust.claimfaker.core.Color;
import com.ust.claimfaker.core.Commerce;
import com.ust.claimfaker.core.Company;
import com.ust.claimfaker.core.Crypto;
import com.ust.claimfaker.core.Currency;
import com.ust.claimfaker.core.DateAndTime;
import com.ust.claimfaker.core.Demographic;
import com.ust.claimfaker.core.Educator;
import com.ust.claimfaker.core.Esports;
import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.File;
import com.ust.claimfaker.core.Finance;
import com.ust.claimfaker.core.Food;
import com.ust.claimfaker.core.Friends;
import com.ust.claimfaker.core.GameOfThrones;
import com.ust.claimfaker.core.Hacker;
import com.ust.claimfaker.core.HarryPotter;
import com.ust.claimfaker.core.Hipster;
import com.ust.claimfaker.core.IdNumber;
import com.ust.claimfaker.core.Internet;
import com.ust.claimfaker.core.Job;
import com.ust.claimfaker.core.Lebowski;
import com.ust.claimfaker.core.LordOfTheRings;
import com.ust.claimfaker.core.Lorem;
import com.ust.claimfaker.core.Matz;
import com.ust.claimfaker.core.Music;
import com.ust.claimfaker.core.Name;
import com.ust.claimfaker.core.Number;
import com.ust.claimfaker.core.Options;
import com.ust.claimfaker.core.PhoneNumber;
import com.ust.claimfaker.core.Pokemon;
import com.ust.claimfaker.core.RickAndMorty;
import com.ust.claimfaker.core.RockBand;
import com.ust.claimfaker.core.Shakespeare;
import com.ust.claimfaker.core.SlackEmoji;
import com.ust.claimfaker.core.Space;
import com.ust.claimfaker.core.Stock;
import com.ust.claimfaker.core.Superhero;
import com.ust.claimfaker.core.Team;
import com.ust.claimfaker.core.TwinPeaks;
import com.ust.claimfaker.core.University;
import com.ust.claimfaker.core.Weather;
import com.ust.claimfaker.core.Witcher;
import com.ust.claimfaker.core.Yoda;
import com.ust.claimfaker.core.Zelda;
import com.ust.claimfaker.core.service.FakeValuesService;
import com.ust.claimfaker.core.service.RandomService;

/**
 * Provides utility methods for generating fake strings, such as names, phone
 * numbers, addresses. generate random strings with given patterns
 *
 * @author ren
 */
public class Faker {
    private final RandomService randomService;
    private final FakeValuesService fakeValuesService;

    private final Ancient ancient;
    private final App app;
    private final Artist artist;
    private final Avatar avatar;
    private final Lorem lorem;
    private final Music music;
    private final Name name;
    private final Number number;
    private final Internet internet;
    private final PhoneNumber phoneNumber;
    private final Pokemon pokemon;
    private final Address address;
    private final Business business;
    private final Book book;
    private final ChuckNorris chuckNorris;
    private final Color color;
    private final Commerce commerce;
    private final Currency currency;
    private final Company company;
    private final Crypto crypto;
    private final IdNumber idNumber;
    private final Hacker hacker;
    private final Options options;
    private final Code code;
    private final Finance finance;
    private final Food food;
    private final GameOfThrones gameOfThrones;
    private final DateAndTime dateAndTime;
    private final Demographic demographic;
    private final Educator educator;
    private final Shakespeare shakespeare;
    private final SlackEmoji slackEmoji;
    private final Space space;
    private final Superhero superhero;
    private final Bool bool;
    private final Team team;
    private final Beer beer;
    private final University university;
    private final Cat cat;
    private final File file;
    private final Stock stock;
    private final LordOfTheRings lordOfTheRings;
    private final Zelda zelda;
    private final HarryPotter harryPotter;
    private final RockBand rockBand;
    private final Esports esports;
    private final Friends friends;
    private final Hipster hipster;
    private final Job job;
    private final TwinPeaks twinPeaks;
    private final RickAndMorty rickAndMorty;
    private final Yoda yoda;
    private final Matz matz;
    private final Witcher witcher;
    private final Weather weather;
    private final Lebowski lebowski;

    public Faker() {
//        this(Locale.ENGLISH);
        this(Locale.US);
    }

    public Faker(Locale locale) {
        this(locale, null);
    }

    public Faker(Random random) {
//        this(Locale.ENGLISH, random);
        this(Locale.US, random);
    }

    public Faker(Locale locale, Random random) {
        this.randomService = new RandomService(random);
        this.fakeValuesService = new FakeValuesService(locale, randomService);

        this.ancient = new Ancient(this);
        this.app = new App(this);
        this.artist = new Artist(this);
        this.avatar = new Avatar(this);
        this.lorem = new Lorem(this);
        this.music = new Music(this);
        this.name = new Name(this);
        this.number = new Number(this);
        this.internet = new Internet(this);
        this.phoneNumber = new PhoneNumber(this);
        this.pokemon = new Pokemon(this);
        this.address = new Address(this);
        this.book = new Book(this);
        this.business = new Business(this);
        this.chuckNorris = new ChuckNorris(this);
        this.color = new Color(this);
        this.idNumber = new IdNumber(this);
        this.hacker = new Hacker(this);
        this.company = new Company(this);
        this.crypto = new Crypto(this);
        this.commerce = new Commerce(this);
        this.currency = new Currency(this);
        this.options = new Options(this);
        this.code = new Code(this);
        this.file = new File(this);
        this.finance = new Finance(this);
        this.food = new Food(this);
        this.gameOfThrones = new GameOfThrones(this);
        this.dateAndTime = new DateAndTime(this);
        this.demographic = new Demographic(this);
        this.educator = new Educator(this);
        this.shakespeare = new Shakespeare(this);
        this.slackEmoji = new SlackEmoji(this);
        this.space = new Space(this);
        this.superhero = new Superhero(this);
        this.team = new Team(this);
        this.bool = new Bool(this);
        this.beer = new Beer(this);
        this.university = new University(this);
        this.cat = new Cat(this);
        this.stock = new Stock(this);
        this.lordOfTheRings = new LordOfTheRings(this);
        this.zelda = new Zelda(this);
        this.harryPotter = new HarryPotter(this);
        this.rockBand = new RockBand(this);
        this.esports = new Esports(this);
        this.friends = new Friends(this);
        this.hipster = new Hipster(this);
        this.job = new Job(this);
        this.twinPeaks = new TwinPeaks(this);
        this.rickAndMorty = new RickAndMorty(this);
        this.yoda = new Yoda(this);
        this.matz = new Matz(this);
        this.witcher = new Witcher(this);
        this.weather = new Weather(this);
        this.lebowski = new Lebowski(this);
    }

    /**
     * Constructs Faker instance with default argument.
     *
     * @return {@link Faker#Faker()}
     */
    public static Faker instance() {
        return new Faker();
    }

    /**
     * Constructs Faker instance with provided {@link Locale}.
     *
     * @param locale - {@link Locale}
     * @return {@link Faker#Faker(Locale)}
     */
    public static Faker instance(Locale locale) {
        return new Faker(locale);
    }

    /**
     * Constructs Faker instance with provided {@link Random}.
     *
     * @param random - {@link Random}
     * @return {@link Faker#Faker(Random)}
     */
    public static Faker instance(Random random) {
        return new Faker(random);
    }

    /**
     * Constructs Faker instance with provided {@link Locale} and {@link Random}.
     *
     * @param locale - {@link Locale}
     * @param random - {@link Random}
     * @return {@link Faker#Faker(Locale, Random)}
     */
    public static Faker instance(Locale locale, Random random) {
        return new Faker(locale, random);
    }

    /**
     * Returns a string with the '#' characters in the parameter replaced with random digits between 0-9 inclusive.
     * <p>
     * For example, the string "ABC##EFG" could be replaced with a string like "ABC99EFG".
     *
     * @param numberString
     * @return
     */
    public String numerify(String numberString) {
        return fakeValuesService.numerify(numberString);
    }

    /**
     * Returns a string with the '?' characters in the parameter replaced with random alphabetic
     * characters.
     * <p>
     * For example, the string "12??34" could be replaced with a string like "12AB34".
     *
     * @param letterString
     * @return
     */
    public String letterify(String letterString) {
        return fakeValuesService.letterify(letterString);
    }

    /**
     * Returns a string with the '?' characters in the parameter replaced with random alphabetic
     * characters.
     * <p>
     * For example, the string "12??34" could be replaced with a string like "12AB34".
     *
     * @param letterString
     * @param isUpper
     * @return
     */
    public String letterify(String letterString, boolean isUpper) {
        return fakeValuesService.letterify(letterString, isUpper);
    }

    /**
     * Applies both a {@link #numerify(String)} and a {@link #letterify(String)}
     * over the incoming string.
     *
     * @param string
     * @return
     */
    public String bothify(String string) {
        return fakeValuesService.bothify(string);
    }

    /**
     * Applies both a {@link #numerify(String)} and a {@link #letterify(String)}
     * over the incoming string.
     *
     * @param string
     * @param isUpper
     * @return
     */
    public String bothify(String string, boolean isUpper) {
        return fakeValuesService.bothify(string, isUpper);
    }

    /**
     * Generates a String that matches the given regular expression.
     */
    public String regexify(String regex) {
        return fakeValuesService.regexify(regex);
    }

    public RandomService random() {
        return this.randomService;
    }

    public Currency currency() {
        return currency;

    }

    FakeValuesService fakeValuesService() {
        return this.fakeValuesService;
    }

    public Ancient ancient() {
        return ancient;
    }

    public App app() {
        return app;
    }

    public Artist artist() {
        return artist;
    }

    public Avatar avatar() {
        return avatar;
    }

    public Music music() {
        return music;
    }

    public Name name() {
        return name;
    }

    public Number number() {
        return number;
    }

    public Internet internet() {
        return internet;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public Pokemon pokemon() {
        return pokemon;
    }

    public Lorem lorem() {
        return lorem;
    }

    public Address address() {
        return address;
    }

    public Book book() {
        return book;
    }

    public Business business() {
        return business;
    }

    public ChuckNorris chuckNorris() {
        return chuckNorris;
    }

    public Color color() {
        return color;
    }

    public Commerce commerce() {
        return commerce;
    }

    public Company company() {
        return company;
    }

    public Crypto crypto() {
        return crypto;
    }

    public Hacker hacker() {
        return hacker;
    }

    public IdNumber idNumber() {
        return idNumber;
    }

    public Options options() {
        return options;
    }

    public Code code() {
        return code;
    }

    public File file() {
        return file;
    }

    public Finance finance() {
        return finance;
    }

    public Food food() {
        return food;
    }

    public GameOfThrones gameOfThrones() {
        return gameOfThrones;
    }

    public DateAndTime date() {
        return dateAndTime;
    }

    public Demographic demographic() {
        return demographic;
    }

    public Educator educator() {
        return educator;
    }

    public SlackEmoji slackEmoji() {
        return slackEmoji;
    }

    public Shakespeare shakespeare() {
        return shakespeare;
    }

    public Space space() {
        return space;
    }

    public Superhero superhero() {
        return superhero;
    }

    public Bool bool() {
        return bool;
    }

    public Team team() {
        return team;
    }

    public Beer beer() {
        return beer;
    }

    public University university() {
        return university;
    }

    public Cat cat() {
        return cat;
    }

    public Stock stock() {
        return stock;
    }

    public LordOfTheRings lordOfTheRings() {
        return lordOfTheRings;
    }

    public Zelda zelda() {
        return zelda;
    }

    public HarryPotter harryPotter() {
        return harryPotter;
    }

    public RockBand rockBand() {
        return rockBand;
    }

    public Esports esports() {
        return esports;
    }

    public Friends friends() {
        return friends;
    }

    public Hipster hipster() {
        return hipster;
    }

    public Job job() {
        return job;
    }

    public TwinPeaks twinPeaks() {
        return twinPeaks;
    }

    public RickAndMorty rickAndMorty() {
        return rickAndMorty;
    }

    public Yoda yoda() {
        return yoda;
    }

    public Matz matz() {
        return matz;
    }

    public Witcher witcher() {
        return witcher;
    }

    public Weather weather() {
        return weather;
    }

    public Lebowski lebowski() {
        return lebowski;
    }

    public String resolve(String key) {
        return this.fakeValuesService.resolve(key, this, this);
    }

    /**
     * Allows the evaluation of native YML expressions to allow you to build your own.
     *
     * The following are valid expressions:
     * <ul>
     *     <li>#{regexify '(a|b){2,3}'}</li>
     *     <li>#{regexify '\\.\\*\\?\\+'}</li>
     *     <li>#{bothify '????','false'}</li>
     *     <li>#{Name.first_name} #{Name.first_name} #{Name.last_name}</li>
     *     <li>#{number.number_between '1','10'}</li>
     * </ul>
     * @param expression (see examples above)
     * @return the evaluated string expression
     * @throws RuntimeException if unable to evaluate the expression
     */
    public String expression(String expression) {
        return this.fakeValuesService.expression(expression, this);
    }
}
