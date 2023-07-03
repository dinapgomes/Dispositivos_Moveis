import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseProvider {
  static final DatabaseProvider instance = DatabaseProvider._();
  DatabaseProvider._();

  static Database? _database;

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    final databasePath = await getDatabasesPath();
    final path = join(databasePath, 'my_database.db');
    return await openDatabase(
      path,
      version: 1,
      onCreate: (db, version) async {
        await db.execute('''
          CREATE TABLE jogos(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT,
            pontuacao INTEGER,
            posicao INTEGER,
            data TEXT
          )
        ''');
      },
    );
  }

  Future<List<Map<String, dynamic>>> buscarJogosOrdenadosPorPontuacao() async {
    final db = await database;
    return await db.query('jogos', orderBy: 'pontuacao DESC');
  }
}
