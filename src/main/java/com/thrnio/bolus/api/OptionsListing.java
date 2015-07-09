package com.thrnio.bolus.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thrnio.bolus.core.OptionsVerb;
import com.thrnio.bolus.core.OptionsVerbParameter;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = OptionsListing.Builder.class)
public class OptionsListing {
  private final OptionsVerb options;
  private final OptionsVerb get;
  private final OptionsVerb head;
  private final OptionsVerb post;
  private final OptionsVerb put;
  private final OptionsVerb delete;
  private final OptionsVerb patch;

  public OptionsListing(OptionsVerb options,
                        OptionsVerb get,
                        OptionsVerb head,
                        OptionsVerb post,
                        OptionsVerb put,
                        OptionsVerb delete,
                        OptionsVerb patch) {
    this.options = options;
    this.get = get;
    this.head = head;
    this.post = post;
    this.put = put;
    this.delete = delete;
    this.patch = patch;
  }

  @JsonProperty("OPTIONS")
  public OptionsVerb getOptions() {
    return options;
  }

  @JsonProperty("GET")
  public OptionsVerb getGet() {
    return get;
  }

  @JsonProperty("HEAD")
  public OptionsVerb getHead() {
    return head;
  }

  @JsonProperty("POST")
  public OptionsVerb getPost() {
    return post;
  }

  @JsonProperty("PUT")
  public OptionsVerb getPut() {
    return put;
  }

  @JsonProperty("DELETE")
  public OptionsVerb getDelete() {
    return delete;
  }

  @JsonProperty("PATCH")
  public OptionsVerb getPatch() {
    return patch;
  }

  public static class Builder {

    private String optionsDescription;
    private String getDescription;
    private String headDescription;
    private String postDescription;
    private String putDescription;
    private String deleteDescription;
    private String patchDescription;

    private List<OptionsVerbParameter> optionsParametersList;
    private List<OptionsVerbParameter> getParametersList;
    private List<OptionsVerbParameter> headParametersList;
    private List<OptionsVerbParameter> postParametersList;
    private List<OptionsVerbParameter> putParametersList;
    private List<OptionsVerbParameter> deleteParametersList;
    private List<OptionsVerbParameter> patchParametersList;

    public Builder setOptionsDescription(String description) {
      this.optionsDescription = description;
      return this;
    }

    public Builder setGetDescription(String description) {
      this.getDescription = description;
      return this;
    }

    public Builder setHeadDescription(String description) {
      this.headDescription = description;
      return this;
    }

    public Builder setPostDescription(String description) {
      this.postDescription = description;
      return this;
    }

    public Builder setPutDescription(String description) {
      this.putDescription = description;
      return this;
    }

    public Builder setDeleteDescription(String description) {
      this.deleteDescription = description;
      return this;
    }

    public Builder setPatchDescription(String description) {
      this.patchDescription = description;
      return this;
    }

    public Builder addOptionsParameter(String name, String type) {
      if (this.optionsParametersList == null) {
        this.optionsParametersList = new ArrayList<>();
      }
      this.optionsParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addOptionsParameter(String name, String type, Boolean required) {
      if (this.optionsParametersList == null) {
        this.optionsParametersList = new ArrayList<>();
      }
      this.optionsParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addOptionsParameter(String name, String type, Boolean required, String description) {
      if (this.optionsParametersList == null) {
        this.optionsParametersList = new ArrayList<>();
      }
      this.optionsParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addGetParameter(String name, String type) {
      if (this.getParametersList == null) {
        this.getParametersList = new ArrayList<>();
      }
      this.getParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addGetParameter(String name, String type, Boolean required) {
      if (this.getParametersList == null) {
        this.getParametersList = new ArrayList<>();
      }
      this.getParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addGetParameter(String name, String type, Boolean required, String description) {
      if (this.getParametersList == null) {
        this.getParametersList = new ArrayList<>();
      }
      this.getParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addHeadParameter(String name, String type) {
      if (this.headParametersList == null) {
        this.headParametersList = new ArrayList<>();
      }
      this.headParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addHeadParameter(String name, String type, Boolean required) {
      if (this.headParametersList == null) {
        this.headParametersList = new ArrayList<>();
      }
      this.headParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addHeadParameter(String name, String type, Boolean required, String description) {
      if (this.headParametersList == null) {
        this.headParametersList = new ArrayList<>();
      }
      this.headParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addPostParameter(String name, String type) {
      if (this.postParametersList == null) {
        this.postParametersList = new ArrayList<>();
      }
      this.postParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addPostParameter(String name, String type, Boolean required) {
      if (this.postParametersList == null) {
        this.postParametersList = new ArrayList<>();
      }
      this.postParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addPostParameter(String name, String type, Boolean required, String description) {
      if (this.postParametersList == null) {
        this.postParametersList = new ArrayList<>();
      }
      this.postParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addPutParameter(String name, String type) {
      if (this.putParametersList == null) {
        this.putParametersList = new ArrayList<>();
      }
      this.putParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addPutParameter(String name, String type, Boolean required) {
      if (this.putParametersList == null) {
        this.putParametersList = new ArrayList<>();
      }
      this.putParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addPutParameter(String name, String type, Boolean required, String description) {
      if (this.putParametersList == null) {
        this.putParametersList = new ArrayList<>();
      }
      this.putParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addDeleteParameter(String name, String type) {
      if (this.deleteParametersList == null) {
        this.deleteParametersList = new ArrayList<>();
      }
      this.deleteParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addDeleteParameter(String name, String type, Boolean required) {
      if (this.deleteParametersList == null) {
        this.deleteParametersList = new ArrayList<>();
      }
      this.deleteParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addDeleteParameter(String name, String type, Boolean required, String description) {
      if (this.deleteParametersList == null) {
        this.deleteParametersList = new ArrayList<>();
      }
      this.deleteParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public Builder addPatchParameter(String name, String type) {
      if (this.patchParametersList == null) {
        this.patchParametersList = new ArrayList<>();
      }
      this.patchParametersList.add(new OptionsVerbParameter(name, type));
      return this;
    }

    public Builder addPatchParameter(String name, String type, Boolean required) {
      if (this.patchParametersList == null) {
        this.patchParametersList = new ArrayList<>();
      }
      this.patchParametersList.add(new OptionsVerbParameter(name, type, required));
      return this;
    }

    public Builder addPatchParameter(String name, String type, Boolean required, String description) {
      if (this.patchParametersList == null) {
        this.patchParametersList = new ArrayList<>();
      }
      this.patchParametersList.add(new OptionsVerbParameter(name, type, required, description));
      return this;
    }

    public OptionsListing build() throws IllegalStateException {
      final OptionsVerb options;
      final OptionsVerb get;
      final OptionsVerb head;
      final OptionsVerb post;
      final OptionsVerb put;
      final OptionsVerb delete;
      final OptionsVerb patch;

      if (this.optionsDescription == null) {
        if (this.optionsParametersList != null) {
          throw new IllegalStateException("Cannot set OPTIONS parameters without a description!");
        }
        else {
          options = null;
        }
      }
      else {
        if (this.optionsParametersList == null) {
          options = new OptionsVerb(this.optionsDescription);
        }
        else {
          options = new OptionsVerb(this.optionsDescription, this.optionsParametersList);
        }
      }

      if (this.getDescription == null) {
        if (this.getParametersList != null) {
          throw new IllegalStateException("Cannot set GET parameters without a description!");
        }
        else {
          get = null;
        }
      }
      else {
        if (this.getParametersList == null) {
          get = new OptionsVerb(this.getDescription);
        }
        else {
          get = new OptionsVerb(this.getDescription, this.getParametersList);
        }
      }

      if (this.headDescription == null) {
        if (this.headParametersList != null) {
          throw new IllegalStateException("Cannot set HEAD parameters without a description!");
        }
        else {
          head = null;
        }
      }
      else {
        if (this.headParametersList == null) {
          head = new OptionsVerb(this.headDescription);
        }
        else {
          head = new OptionsVerb(this.headDescription, this.headParametersList);
        }
      }

      if (this.postDescription == null) {
        if (this.postParametersList != null) {
          throw new IllegalStateException("Cannot set POST parameters without a description!");
        }
        else {
          post = null;
        }
      }
      else {
        if (this.postParametersList == null) {
          post = new OptionsVerb(this.postDescription);
        }
        else {
          post = new OptionsVerb(this.postDescription, this.postParametersList);
        }
      }

      if (this.putDescription == null) {
        if (this.putParametersList != null) {
          throw new IllegalStateException("Cannot set PUT parameters without a description!");
        }
        else {
          put = null;
        }
      }
      else {
        if (this.putParametersList == null) {
          put = new OptionsVerb(this.putDescription);
        }
        else {
          put = new OptionsVerb(this.putDescription, this.putParametersList);
        }
      }

      if (this.deleteDescription == null) {
        if (this.deleteParametersList != null) {
          throw new IllegalStateException("Cannot set DELETE parameters without a description!");
        }
        else {
          delete = null;
        }
      }
      else {
        if (this.deleteParametersList == null) {
          delete = new OptionsVerb(this.deleteDescription);
        }
        else {
          delete = new OptionsVerb(this.deleteDescription, this.deleteParametersList);
        }
      }

      if (this.patchDescription == null) {
        if (this.patchParametersList != null) {
          throw new IllegalStateException("Cannot set PATCH parameters without a description!");
        }
        else {
          patch = null;
        }
      }
      else {
        if (this.patchParametersList == null) {
          patch = new OptionsVerb(this.patchDescription);
        }
        else {
          patch = new OptionsVerb(this.patchDescription, this.patchParametersList);
        }
      }

      return new OptionsListing(options, get, head, post, put, delete, patch);
    }
  }
}
