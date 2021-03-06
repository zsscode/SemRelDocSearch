## Purpose 

Facilitate pairwise document comparison and related documents search using efficient graph-based approaches.

## Dependencies

1. [Elastic Search](https://www.elastic.co/downloads/elasticsearch)
2. [Jena TDB](https://jena.apache.org/documentation/tdb/)


## Installation Instructions

1. `git clone https://github.com/adityamogadala/SemRelDocSearch.git`
1. Code is written Java. Make sure that all required Java dependencies are installed.
2. Setup an elasticsearch Index.
	* Download elasticsearch and run
		* `$bin/elasticsearch.bat`
	* Open `http://localhost:9200/_plugin/marvel/sense/index.html` in browser
	* Enter text from "elasticSearch\_index.txt" file to create a new index. If desired, customize index name (default: docIndex) and document type name (default: news))
		* Tip-1: For large collections, increase the shard count (e.g. 5).
		* Tip-2: If necessary, reset with: DELETE docIndex and then create new index.
3. Download [Pre-set DBPedia and Wiki Category Triplestores](http://people.aifb.kit.edu/amo/eswc2016/data/triple_data.7z). Keep it inside clone folder.

## Get Started

Below, we see how to use the code for document search and comparison.

### Related Document Search

1. Instantiate class `SemExpRelDocSearch` with following arguments 
	* Document triple store path (where expanded documents will be stored).
	* ElasticSearch index and document type name.
	* Expansion radius of documents (edges that will be traversed in knowledge graph to enrich documents), default: 2 (should not be greater than 3).
	* Candidate Set Size: defines how many candidate documents Pre-Search returns for closer similarity computation in Full Search step. Default: 20 (can be increased)

2. Find related documents for a new document (which will be added to the collection in the process)
	* Call method `getRelatedDocuments` with a query document enriched with annotations using class `AnnotatedDoc`.

3. Tip: To add document collection at once.
	* Use method `bulkAddDocuments`.

		
### Pairwise Document Similarity 

Compile and Run `SemEvalAnnotator.java` inside `de.paul.corpora.annotators` with an argument to path containing a file containing sentence pairs or document pairs in 
each line.


## Citation

Christian Paul, Achim Rettinger, Aditya Mogadala, Craig A. Knoblock, Pedro Szekely. In 13th Extended Semantic Web Conference (ESWC). Springer International Publishing. (2016) [Best Research Track Paper Candidate]
