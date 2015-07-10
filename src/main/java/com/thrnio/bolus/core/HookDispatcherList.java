package com.thrnio.bolus.core;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class HookDispatcherList implements List<HookDispatcher> {
  private List<HookDispatcher> dispatchers;

  public HookDispatcherList(Map<String, Map<String, Object>> dispatcherConfig) {
    this.dispatchers = new ArrayList<>();
    final ServiceLoader<HookDispatcherFactory> services = ServiceLoader.load(HookDispatcherFactory.class);
    for (HookDispatcherFactory dispatcher : services) {
      if (dispatcherConfig.containsKey(dispatcher.dispatcherConfigName())) {
        System.out.println("Attached dispatcher: " + dispatcher.dispatcherConfigName());
        this.dispatchers.add(dispatcher.configure(dispatcherConfig.get(dispatcher.dispatcherConfigName())).build());
      }
    }
  }

  @Override
  public int size() {
    return dispatchers.size();
  }

  @Override
  public boolean isEmpty() {
    return dispatchers.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return dispatchers.contains(o);
  }

  @Override
  public Iterator<HookDispatcher> iterator() {
    return dispatchers.iterator();
  }

  @Override
  public Object[] toArray() {
    return dispatchers.toArray();
  }

  @Override
  public <T> T[] toArray(T[] ts) {
    return dispatchers.toArray(ts);
  }

  @Override
  public boolean add(HookDispatcher hookDispatcher) {
    return dispatchers.add(hookDispatcher);
  }

  @Override
  public boolean remove(Object o) {
    return dispatchers.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {
    return dispatchers.containsAll(collection);
  }

  @Override
  public boolean addAll(Collection<? extends HookDispatcher> collection) {
    return dispatchers.addAll(collection);
  }

  @Override
  public boolean addAll(int i, Collection<? extends HookDispatcher> collection) {
    return dispatchers.addAll(i, collection);
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    return dispatchers.removeAll(collection);
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    return dispatchers.retainAll(collection);
  }

  @Override
  public void replaceAll(UnaryOperator<HookDispatcher> unaryOperator) {
    dispatchers.replaceAll(unaryOperator);
  }

  @Override
  public void sort(Comparator<? super HookDispatcher> comparator) {
    dispatchers.sort(comparator);
  }

  @Override
  public void clear() {
    dispatchers.clear();
  }

  @Override
  public boolean equals(Object o) {
    return dispatchers.equals(o);
  }

  @Override
  public int hashCode() {
    return dispatchers.hashCode();
  }

  @Override
  public HookDispatcher get(int i) {
    return dispatchers.get(i);
  }

  @Override
  public HookDispatcher set(int i, HookDispatcher hookDispatcher) {
    return dispatchers.set(i, hookDispatcher);
  }

  @Override
  public void add(int i, HookDispatcher hookDispatcher) {
    dispatchers.add(i, hookDispatcher);
  }

  @Override
  public HookDispatcher remove(int i) {
    return dispatchers.remove(i);
  }

  @Override
  public int indexOf(Object o) {
    return dispatchers.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return dispatchers.lastIndexOf(o);
  }

  @Override
  public ListIterator<HookDispatcher> listIterator() {
    return dispatchers.listIterator();
  }

  @Override
  public ListIterator<HookDispatcher> listIterator(int i) {
    return dispatchers.listIterator(i);
  }

  @Override
  public List<HookDispatcher> subList(int i, int i1) {
    return dispatchers.subList(i, i1);
  }

  @Override
  public Spliterator<HookDispatcher> spliterator() {
    return dispatchers.spliterator();
  }

  @Override
  public boolean removeIf(Predicate<? super HookDispatcher> predicate) {
    return dispatchers.removeIf(predicate);
  }

  @Override
  public Stream<HookDispatcher> stream() {
    return dispatchers.stream();
  }

  @Override
  public Stream<HookDispatcher> parallelStream() {
    return dispatchers.parallelStream();
  }

  @Override
  public void forEach(Consumer<? super HookDispatcher> consumer) {
    dispatchers.forEach(consumer);
  }
}
