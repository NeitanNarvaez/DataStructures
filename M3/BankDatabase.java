import java.util.*;

public class BankDatabase {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public boolean addAccount(BankAccount acc) {
        if (findAccount(acc.getAccountNumber()) == null) {
            accounts.add(acc);
            return true;
        }
        return false;
    }

    public boolean removeAccount(String number) {
        BankAccount acc = findAccount(number);
        if (acc != null) {
            accounts.remove(acc);
            return true;
        }
        return false;
    }

    public BankAccount findAccount(String number) {
        for (BankAccount acc : accounts)
            if (acc.getAccountNumber().equals(number)) return acc;
        return null;
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return accounts;
    }

    // Reporte ordenado por saldo (merge sort)
    public List<BankAccount> getAccountsSortedByBalance() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted = mergeSort(sorted);
        return sorted;
    }

    private List<BankAccount> mergeSort(List<BankAccount> lista) {
        if (lista.size() <= 1) return lista;
        int mid = lista.size() / 2;
        List<BankAccount> left = mergeSort(lista.subList(0, mid));
        List<BankAccount> right = mergeSort(lista.subList(mid, lista.size()));
        return merge(left, right);
    }

    private List<BankAccount> merge(List<BankAccount> left, List<BankAccount> right) {
        List<BankAccount> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getBalance() < right.get(j).getBalance()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // Búsqueda binaria por número de cuenta
    public BankAccount binarySearch(String number) {
        ArrayList<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing(BankAccount::getAccountNumber));
        int min = 0, max = sorted.size()-1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int cmp = sorted.get(mid).getAccountNumber().compareTo(number);
            if (cmp == 0) return sorted.get(mid);
            if (cmp < 0) min = mid + 1;
            else max = mid - 1;
        }
        return null;
    }
}
