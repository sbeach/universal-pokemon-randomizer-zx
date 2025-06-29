package mock;

import com.dabomstew.pkrandom.Settings;
import com.dabomstew.pkrandom.pokemon.*;
import com.dabomstew.pkrandom.romhandlers.AbstractRomHandler;

import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Used for testing functions of AbstractRomHandler with default implementations
public class MockRomHandler extends AbstractRomHandler {

    public List<Pokemon> pokemonList = Collections.emptyList();
    private List<Pokemon> starters = Collections.emptyList();

    public MockRomHandler(Random random) {
        super(random, null);
    }

    @Override
    public boolean loadRom(String filename) {
        return false;
    }

    @Override
    public boolean saveRomFile(String filename, long seed) {
        return false;
    }

    @Override
    public boolean saveRomDirectory(String filename) {
        return false;
    }

    @Override
    public String loadedFilename() {
        return "";
    }

    @Override
    public boolean hasGameUpdateLoaded() {
        return false;
    }

    @Override
    public boolean loadGameUpdate(String filename) {
        return false;
    }

    @Override
    public void removeGameUpdate() {

    }

    @Override
    public String getGameUpdateVersion() {
        return "";
    }

    @Override
    public void printRomDiagnostics(PrintStream logStream) {

    }

    @Override
    public boolean isRomValid() {
        return false;
    }

    @Override
    public List<Pokemon> getPokemon() {
        return pokemonList;
    }

    @Override
    public List<Pokemon> getPokemonInclFormes() {
        return pokemonList;
    }

    @Override
    public List<Pokemon> getAltFormes() {
        return Collections.emptyList();
    }

    @Override
    public List<MegaEvolution> getMegaEvolutions() {
        return Collections.emptyList();
    }

    @Override
    public Pokemon getAltFormeOfPokemon(Pokemon pk, int forme) {
        return null;
    }

    @Override
    public List<Pokemon> getIrregularFormes() {
        return Collections.emptyList();
    }

    @Override
    public void removeEvosForPokemonPool() {

    }

    @Override
    public List<Pokemon> getStarters() {
        return starters;
    }

    @Override
    public boolean setStarters(List<Pokemon> newStarters) {
        starters = newStarters;
        return true;
    }

    @Override
    public boolean hasStarterAltFormes() {
        return false;
    }

    @Override
    public int starterCount() {
        return 3;
    }

    @Override
    public boolean supportsStarterHeldItems() {
        return false;
    }

    @Override
    public List<Integer> getStarterHeldItems() {
        return Collections.emptyList();
    }

    @Override
    public void setStarterHeldItems(List<Integer> items) {

    }

    @Override
    public Map<Integer, StatChange> getUpdatedPokemonStats(int generation) {
        return Collections.emptyMap();
    }

    @Override
    public int abilitiesPerPokemon() {
        return 0;
    }

    @Override
    public int highestAbilityIndex() {
        return 0;
    }

    @Override
    public Map<Integer, List<Integer>> getAbilityVariations() {
        return Collections.emptyMap();
    }

    @Override
    public boolean hasMegaEvolutions() {
        return false;
    }

    @Override
    public List<EncounterSet> getEncounters(boolean useTimeOfDay) {
        return Collections.emptyList();
    }

    @Override
    public void setEncounters(boolean useTimeOfDay, List<EncounterSet> encounters) {

    }

    @Override
    public boolean hasWildAltFormes() {
        return false;
    }

    @Override
    public void enableGuaranteedPokemonCatching() {

    }

    @Override
    public List<Trainer> getTrainers() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getMainPlaythroughTrainers() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getEliteFourTrainers(boolean isChallengeMode) {
        return Collections.emptyList();
    }

    @Override
    public void setTrainers(List<Trainer> trainerData, boolean doubleBattleMode) {

    }

    @Override
    public boolean hasPhysicalSpecialSplit() {
        return false;
    }

    @Override
    public List<Move> getMoves() {
        return Collections.emptyList();
    }

    @Override
    public Map<Integer, List<MoveLearnt>> getMovesLearnt() {
        return Collections.emptyMap();
    }

    @Override
    public void setMovesLearnt(Map<Integer, List<MoveLearnt>> movesets) {

    }

    @Override
    public Map<Integer, List<Integer>> getEggMoves() {
        return Collections.emptyMap();
    }

    @Override
    public void setEggMoves(Map<Integer, List<Integer>> eggMoves) {

    }

    @Override
    public boolean supportsFourStartingMoves() {
        return false;
    }

    @Override
    public List<StaticEncounter> getStaticPokemon() {
        return Collections.emptyList();
    }

    @Override
    public boolean setStaticPokemon(List<StaticEncounter> staticPokemon) {
        return false;
    }

    @Override
    public boolean canChangeStaticPokemon() {
        return false;
    }

    @Override
    public boolean hasStaticAltFormes() {
        return false;
    }

    @Override
    public boolean hasMainGameLegendaries() {
        return false;
    }

    @Override
    public List<Integer> getMainGameLegendaries() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getSpecialMusicStatics() {
        return Collections.emptyList();
    }

    @Override
    public void applyCorrectStaticMusic(Map<Integer, Integer> specialMusicStaticChanges) {

    }

    @Override
    public boolean hasStaticMusicFix() {
        return false;
    }

    @Override
    public List<TotemPokemon> getTotemPokemon() {
        return Collections.emptyList();
    }

    @Override
    public void setTotemPokemon(List<TotemPokemon> totemPokemon) {

    }

    @Override
    public List<Integer> getTMMoves() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getHMMoves() {
        return Collections.emptyList();
    }

    @Override
    public void setTMMoves(List<Integer> moveIndexes) {

    }

    @Override
    public int getTMCount() {
        return 0;
    }

    @Override
    public int getHMCount() {
        return 0;
    }

    @Override
    public Map<Pokemon, boolean[]> getTMHMCompatibility() {
        return Collections.emptyMap();
    }

    @Override
    public void setTMHMCompatibility(Map<Pokemon, boolean[]> compatData) {

    }

    @Override
    public boolean hasMoveTutors() {
        return false;
    }

    @Override
    public List<Integer> getMoveTutorMoves() {
        return Collections.emptyList();
    }

    @Override
    public void setMoveTutorMoves(List<Integer> moves) {

    }

    @Override
    public Map<Pokemon, boolean[]> getMoveTutorCompatibility() {
        return Collections.emptyMap();
    }

    @Override
    public void setMoveTutorCompatibility(Map<Pokemon, boolean[]> compatData) {

    }

    @Override
    public boolean canChangeTrainerText() {
        return false;
    }

    @Override
    public List<String> getTrainerNames() {
        return Collections.emptyList();
    }

    @Override
    public void setTrainerNames(List<String> trainerNames) {

    }

    @Override
    public TrainerNameMode trainerNameMode() {
        return null;
    }

    @Override
    public List<Integer> getTCNameLengthsByTrainer() {
        return Collections.emptyList();
    }

    @Override
    public List<String> getTrainerClassNames() {
        return Collections.emptyList();
    }

    @Override
    public void setTrainerClassNames(List<String> trainerClassNames) {

    }

    @Override
    public boolean fixedTrainerClassNamesLength() {
        return false;
    }

    @Override
    public List<Integer> getDoublesTrainerClasses() {
        return Collections.emptyList();
    }

    @Override
    public ItemList getAllowedItems() {
        return null;
    }

    @Override
    public ItemList getNonBadItems() {
        return null;
    }

    @Override
    public List<Integer> getEvolutionItems() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getUniqueNoSellItems() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getRegularShopItems() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getOPShopItems() {
        return Collections.emptyList();
    }

    @Override
    public String[] getItemNames() {
        return new String[0];
    }

    @Override
    public List<Integer> getRequiredFieldTMs() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getCurrentFieldTMs() {
        return Collections.emptyList();
    }

    @Override
    public void setFieldTMs(List<Integer> fieldTMs) {

    }

    @Override
    public List<Integer> getRegularFieldItems() {
        return Collections.emptyList();
    }

    @Override
    public void setRegularFieldItems(List<Integer> items) {

    }

    @Override
    public boolean hasShopRandomization() {
        return false;
    }

    @Override
    public Map<Integer, Shop> getShopItems() {
        return Collections.emptyMap();
    }

    @Override
    public void setShopItems(Map<Integer, Shop> shopItems) {

    }

    @Override
    public void setShopPrices() {

    }

    @Override
    public List<IngameTrade> getIngameTrades() {
        return Collections.emptyList();
    }

    @Override
    public void setIngameTrades(List<IngameTrade> trades) {

    }

    @Override
    public boolean hasDVs() {
        return false;
    }

    @Override
    public void removeImpossibleEvolutions(Settings settings) {

    }

    @Override
    public void makeEvolutionsEasier(Settings settings) {

    }

    @Override
    public void removeTimeBasedEvolutions() {

    }

    @Override
    public List<Integer> getFieldMoves() {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getEarlyRequiredHMMoves() {
        return Collections.emptyList();
    }

    @Override
    public String getROMName() {
        return "";
    }

    @Override
    public String getROMCode() {
        return "";
    }

    @Override
    public String getSupportLevel() {
        return "";
    }

    @Override
    public String getDefaultExtension() {
        return "";
    }

    @Override
    public int internalStringLength(String string) {
        return 0;
    }

    @Override
    public void randomizeIntroPokemon() {

    }

    @Override
    public BufferedImage getMascotImage() {
        return null;
    }

    @Override
    public int generationOfPokemon() {
        return 0;
    }

    @Override
    public boolean isEffectivenessUpdated() {
        return false;
    }

    @Override
    public boolean hasFunctionalFormes() {
        return false;
    }
}
